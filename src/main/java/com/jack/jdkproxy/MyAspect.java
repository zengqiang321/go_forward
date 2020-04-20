package com.jack.jdkproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by manchong on 2020/4/5.
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.jack.jdkproxy..*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public void round(ProceedingJoinPoint pjp){
        System.out.println("aop........");
    }
}
