package com.jack.design.behavioral.chain_of_responsibility.demo1;

/**
 * Created by manchong on 2020/4/14.
 */
public class Main {

    public static void main(String[] args) {
        IPlayer player = new Player1(new Player2(new Player3(null)));
        Response resp = player.handler(2);
        System.out.println(resp);

        resp = player.handler(3);
        System.out.println(resp);

    }
}
