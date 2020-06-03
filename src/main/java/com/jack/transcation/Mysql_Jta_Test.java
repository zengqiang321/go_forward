package com.jack.transcation;

/**
 * Created by manchong on 2020/6/2.
 */
public class Mysql_Jta_Test {

    public static void main(String[] args) {
//        UserTransaction userTransaction=//我们并没有说明UserTransaction实例是如何构建的，这是由事务管理器(TM)实现者提供的，而目前我们还没有接触过任何事务管理器
//        try{
//            //开启分布式事务
//            userTransaction.begin();
//
//            //执行事务分支1
//            conn1 = db1.getConnection();
//            ps1= conn1.prepareStatement("INSERT into user(name,age) VALUES ('tianshouzhi',23)");
//            ps1.executeUpdate();
//
//            //执行事务分支2
//            conn2 = db2.getConnection();
//            ps2 = conn2.prepareStatement("INSERT into user(name,age) VALUES ('tianshouzhi',23)");
//            ps2.executeUpdate();
//            //提交，两阶段提交发生在这个方法内部
//            userTransaction.commit();
//        }catch (Exception e){
//            try {
//                userTransaction.rollback();//回滚
//            } catch (SystemException ignore) {
//            }
//        }


    }
}
