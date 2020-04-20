package com.jack.design.behavioral.chain_and_command;

/**
 * Created by manchong on 2020/4/14.
 */
public  abstract class Player implements IPlayer {

    private Player nextPlayer;

    public Player(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public final Response handler(int level) {
        if(getLevel() ==level ) {
            return handlerRequest();
        }

        if(this.nextPlayer != null) {
            return this.nextPlayer.handler(level);
        }

        return new Response("No support handler!!!!");
    }

    protected abstract Response handlerRequest();

    protected abstract int getLevel();

}
