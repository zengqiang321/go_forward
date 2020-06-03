package com.jack.spring_code_src;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by manchong on 2020/5/29.
 */
//@Component
public class MyBeanPostProcessor2 implements BeanPostProcessor,Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("MyBeanPostProcessor2.postProcessBeforeInitialization invoked.Bean:"+bean+",BeanName:"+beanName);

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor2.postProcessAfterInitialization invoked.Bean:"+bean+",BeanName:"+beanName);
        return bean;
    }
}
