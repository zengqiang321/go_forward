package com.jack.design.behavioral.command.demo2;

/**
 * Created by manchong on 2020/4/16.
 */
public class Invoker {

    public AbstractCommand command;
    public Invoker(AbstractCommand command){
        this.command = command;
    }

    public void action(){
        command.execute();
    }

}
