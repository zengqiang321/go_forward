package com.jack.design.behavioral.command.demo2;

/**
 * Created by manchong on 2020/4/16.
 */
public class ConcreteCommand2 extends AbstractCommand {

    public ConcreteCommand2() {
        super(new ConcreteReceiver2());
    }

    @Override
    void execute() {
        super.receiver.dosomeThing();
    }
}
