package com.jack.rabbitmq;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by manchong on 2019/7/30.
 */
public class T1 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        MessageProducer messageProducer=(MessageProducer)context.getBean("messageProducer");

        for (int i=0;i<10;i++) {
            messageProducer.createMessage(null,""+i);
        }

    }

}
