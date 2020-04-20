package com.jack.design.behavioral.command.demo1;

/**
 * Created by manchong on 2020/4/16.
 */
public class ConcreteReceiver1 extends Receiver {

    @Override
    void dosomeThing() {
        System.out.println("我是执行值1，我在处理事情.......");
    }
}
