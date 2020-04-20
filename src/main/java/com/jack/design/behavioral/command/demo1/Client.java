package com.jack.design.behavioral.command.demo1;

/**
 * Created by manchong on 2020/4/16.
 */
public class Client {

    public static void main(String[] args) {


        AbstractCommand command = new ConcreteCommand1( new ConcreteReceiver1());
        Invoker invoker = new Invoker(command);
        invoker.action();

        //

    }

}
