package com.jack.design.behavioral.command.demo2;

/**
 * Created by manchong on 2020/4/16.
 */
public abstract class AbstractCommand {


    protected Receiver receiver;
    public AbstractCommand(Receiver receiver){
        this.receiver = receiver;
    }

    abstract void execute();

}
