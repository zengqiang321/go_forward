package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/17.
 */
public class DoorCloseCommand extends Command {

    public DoorCloseCommand() {
        super(new DoorOpenOrClose());
    }

    @Override
    public void execute() {
        openOrClose.close();
    }
}
