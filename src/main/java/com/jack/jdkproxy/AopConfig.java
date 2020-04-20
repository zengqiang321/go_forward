package com.jack.jdkproxy;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by manchong on 2020/4/5.
 */

@EnableAspectJAutoProxy
@Configuration
public class AopConfig {


    public void pointcut(){}

}
