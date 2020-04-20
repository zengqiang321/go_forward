package com.jack.design.behavioral.command.demo2;

/**
 * Created by manchong on 2020/4/16.
 */
public class Client {

    public static void main(String[] args) {


        AbstractCommand command = new ConcreteCommand1();
        Invoker invoker = new Invoker(command);
        invoker.action();


        command = new ConcreteCommand2();
        invoker = new Invoker(command);
        invoker.action();

    }

}
