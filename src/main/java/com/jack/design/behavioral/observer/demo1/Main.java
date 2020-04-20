package com.jack.design.behavioral.observer.demo1;

/**
 * Created by manchong on 2020/4/9.
 */
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.addObserver(new Mum());
        Did did = new Did(child);
        child.weekUp();
    }

}
