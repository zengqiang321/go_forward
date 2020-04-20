package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/17.
 */
public class LigtOpenCommand extends Command {
    public LigtOpenCommand() {
        super(new LigtOpenOrClose());
    }

    @Override
    public void execute() {
        openOrClose.open();
    }
}
