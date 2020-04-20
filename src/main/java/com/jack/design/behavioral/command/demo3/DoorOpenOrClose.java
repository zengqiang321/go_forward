package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/17.
 */
public class DoorOpenOrClose implements OpenOrClose {

    @Override
    public void open() {
        System.out.println("door open");
    }

    @Override
    public void close() {
        System.out.println("door close");
    }
}
