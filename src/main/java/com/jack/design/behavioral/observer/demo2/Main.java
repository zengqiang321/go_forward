package com.jack.design.behavioral.observer.demo2;

/**
 * Created by manchong on 2020/4/9.
 */
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.addEventListener(new Did());
        child.addEventListener(new Mum());
        child.weekUp();
    }

}
