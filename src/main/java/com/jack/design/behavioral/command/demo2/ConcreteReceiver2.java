package com.jack.design.behavioral.command.demo2;

/**
 * Created by manchong on 2020/4/16.
 */
public class ConcreteReceiver2 extends Receiver {

    @Override
    void dosomeThing() {
        System.out.println("我是执行者2，我在处理事情.......");
    }
}
