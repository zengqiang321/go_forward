package com.jack.design.behavioral.chain_and_command;

/**
 * Created by manchong on 2020/4/16.
 */
public abstract class Command {
    protected IPlayer iPlayer;
    public Command(IPlayer iPlayer){
        this.iPlayer=iPlayer;
    }

    abstract Object execute();

}
