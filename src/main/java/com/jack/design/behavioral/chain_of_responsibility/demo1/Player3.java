package com.jack.design.behavioral.chain_of_responsibility.demo1;

/**
 * Created by manchong on 2020/4/14.
 */
public class Player3 extends Player {

    public Player3(Player nextPlayer) {
        super(nextPlayer);
    }

    @Override
    public Response handlerRequest() {
        return new Response("Player3 handler request");
    }

    @Override
    public int getLevel() {
        return 3;
    }
}
