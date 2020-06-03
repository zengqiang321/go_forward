package com.jack.transcation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  本地事务:
 *   Connection conn = ... //获取数据库连接
 *   conn.setAutoCommit(false); //开启事务
 *   try{
 *      //...执行增删改查sql
 *      conn.commit(); //提交事务
 *   } catch (Exception e) {
 *      conn.rollback();//事务回滚
 *   } finally{
 *      conn.close();//关闭链接
 *   }
 *
 *
 *
 * Created by manchong on 2020/6/1.
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-application.xml","classpath:spring-datasource.xml");
        UserDao userDao =(UserDao) context.getBean("jdbcUserDao");
        UserDao.UserInfo userInfo = userDao.getUserInfo(62670);
        System.out.println(userInfo);
        //测试单数据源事务回滚
//        userDao.insert(1,1);
//        userDao.insert2(2,1);

    }




}
