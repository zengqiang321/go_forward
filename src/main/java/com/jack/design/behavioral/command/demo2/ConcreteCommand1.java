package com.jack.design.behavioral.command.demo2;


/**
 * Created by manchong on 2020/4/16.
 */
public class ConcreteCommand1  extends AbstractCommand {

    public ConcreteCommand1(){
        super(new ConcreteReceiver1());
    }


    @Override
    void execute() {
        super.receiver.dosomeThing();
    }
}
