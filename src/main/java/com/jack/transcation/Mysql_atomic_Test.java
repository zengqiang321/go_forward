package com.jack.transcation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by manchong on 2020/6/3.
 */
public class Mysql_atomic_Test {

    public static void main(String[] args) {

        Mysql_atomic_Test atomic_test = new Mysql_atomic_Test();
        atomic_test.atomicOper();


    }


    public void atomicOper(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-application.xml","classpath:spring-atomikos-druid.xml");
        UserDao userDao =(UserDao) context.getBean("jdbcUserDao");
        UserDao.UserInfo userInfo = userDao.getUserInfo(62670);
        System.out.println(userInfo);
        //测试单数据源事务回滚
//        userDao.insert(1,1);
//        userDao.insert2(2,1);

        //测试多数据源回滚
        TopicFollowDao topicDao = context.getBean(TopicFollowDao.class);
        topicDao.updateTopic(34,(int)(System.currentTimeMillis()/1000));
        userDao.insert2(2,1);//主键冲突发生异常需要回滚
    }


}
