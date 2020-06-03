package com.jack.transcation;

import com.mysql.cj.api.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.MysqlXAConnection;
import com.mysql.cj.jdbc.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 在这个案例中，演示了2个RM的情况下分布式事务的工作流程。因为我们充当了"人肉事务管理器”TM，
 * 因此很多本应该由TM来处理的工作处理细节也直接体现在上述代码中，如:生成全局事务id和分支事务id、在RM上开启事务分支、两阶段提交等。
 * 虽然我们自己作为"人肉事务管理器”是很不可靠的，但是上述代码可以让我们了解一个TM内部的主要工作流程是怎样的。
* 在实际开发中，代码绝不会像上表面那样复杂，因为我们通常都会使用第三方或者容器提供的TM功能，因此在操作分布式事务时，代码可以得到极大的简化
 * Created by manchong on 2020/6/2.
 */
public class Mysql_XA_2PC_Test {

    public static void main(String[] args) throws Exception{

        //true表示打印XA语句,，用于调试
        boolean logXaCommands = true;
        // 获得资源管理器操作接口实例 RM1
        Connection conn1 = DriverManager.getConnection("jdbc:mysql://172.31.0.68:3306/who_bi_recommend?useUnicode=true", "test_update", "l8ka65");
        XAConnection xaConn1 = new MysqlXAConnection((JdbcConnection) conn1, logXaCommands);
        XAResource rm1 = xaConn1.getXAResource();

        // 获得资源管理器操作接口实例 RM2
        Connection conn2 = DriverManager.getConnection("jdbc:mysql://172.31.0.68:3306/who_bi_recommend?useUnicode=true", "test_update", "l8ka65");
        XAConnection xaConn2 = new MysqlXAConnection((JdbcConnection) conn2, logXaCommands);
        XAResource rm2 = xaConn2.getXAResource();

        // AP请求TM执行一个分布式事务，TM生成全局事务id
        byte[] gtrid = "g12345".getBytes();
        int formatId = 1;

        try {
            // ==============分别执行RM1和RM2上的事务分支====================
            // TM生成rm1上的事务分支id
            byte[] bqual1 = "b00001".getBytes();
            Xid xid1 = new MysqlXid(gtrid, bqual1, formatId);
            // 执行rm1上的事务分支
            rm1.start(xid1, XAResource.TMNOFLAGS);//One of TMNOFLAGS, TMJOIN, or TMRESUME.
            PreparedStatement ps1 = conn1.prepareStatement("update who_style_topic_follow set create_time=1 where id=34");
            ps1.execute();
            rm1.end(xid1, XAResource.TMSUCCESS);



            // TM生成rm2上的事务分支id
            byte[] bqual2 = "b00002".getBytes();
            Xid xid2 = new MysqlXid(gtrid, bqual2, formatId);
            // 执行rm2上的事务分支
            rm2.start(xid2, XAResource.TMNOFLAGS);
            PreparedStatement ps2 = conn2.prepareStatement("insert into who_style_small_top(user_id,update_time) values(2,1)");
            ps2.execute();
            rm2.end(xid2, XAResource.TMSUCCESS);


            // ===================两阶段提交================================
            // phase1：询问所有的RM 准备提交事务分支
            int rm1_prepare = rm1.prepare(xid1);
            int rm2_prepare = rm2.prepare(xid2);
            // phase2：提交所有事务分支
            boolean onePhase = false; //TM判断有2个事务分支，所以不能优化为一阶段提交
            if (rm1_prepare == XAResource.XA_OK
                    && rm2_prepare == XAResource.XA_OK
                    ) {//所有事务分支都prepare成功，提交所有事务分支
                rm1.commit(xid1, onePhase);
                rm2.commit(xid2, onePhase);
            } else {//如果有事务分支没有成功，则回滚
                rm1.rollback(xid1);
                rm1.rollback(xid2);
            }
        } catch (XAException e) {
            // 如果出现异常，也要进行回滚
            e.printStackTrace();
        }

    }

}
