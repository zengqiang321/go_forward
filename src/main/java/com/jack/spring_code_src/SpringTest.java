package com.jack.spring_code_src;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by manchong on 2020/4/12.
 */
public class SpringTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-application.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.test();
    }

}
