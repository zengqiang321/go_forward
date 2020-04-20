package com.jack.design.behavioral.command.demo1;



/**
 * Created by manchong on 2020/4/16.
 */
public class ConcreteCommand1  extends AbstractCommand {

    private Receiver receiver;
    public ConcreteCommand1(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    void execute() {
        receiver.dosomeThing();
    }
}
