package com.jack.design.behavioral.chain_and_command;

import java.util.concurrent.TimeUnit;

/**
 * Created by manchong on 2020/4/16.
 */
public class BeatDrumOnce extends Command {

    public BeatDrumOnce(IPlayer iPlayer) {
        super(iPlayer);
    }

    @Override
    Object execute() {
        try {
            TimeUnit.SECONDS.sleep(1);
            return iPlayer.handler(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
