package com.jack.design.behavioral.chain_and_command;

/**
 * Created by manchong on 2020/4/14.
 */
public class Player1 extends Player {

    public Player1(Player nextPlayer) {
        super(nextPlayer);
    }

    @Override
    public Response handlerRequest() {
        return new Response("Player1 handler request");
    }


    @Override
    public  int getLevel() {
        return 1;
    }
}
