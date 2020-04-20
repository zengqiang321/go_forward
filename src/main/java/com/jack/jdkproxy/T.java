package com.jack.jdkproxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;

/**
 * Created by manchong on 2020/4/5.
 */

@ComponentScan("com.jack.jdkproxy.*")
public class T {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        UserService bean = context.getBean(UserService.class);
        bean.login("dd","pas");
    }

}
