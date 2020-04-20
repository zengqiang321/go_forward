package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/17.
 */
public class LigtOpenOrClose implements OpenOrClose {
    @Override
    public void open() {
        System.out.println("Ligt open ");
    }

    @Override
    public void close() {
        System.out.println("Ligt close ");
    }
}
