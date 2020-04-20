package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/16.
 */
public abstract class Command {

    protected OpenOrClose openOrClose;

    public Command(OpenOrClose openOrClose){
        this.openOrClose = openOrClose;
    }

    public abstract void execute();

}
