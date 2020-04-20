package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/17.
 */
public class Invoker {


    public void action(Command command) {
        command.execute();
    }

}
