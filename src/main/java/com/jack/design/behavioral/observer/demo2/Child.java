package com.jack.design.behavioral.observer.demo2;

/**
 * Created by manchong on 2020/4/19.
 */
public class Child extends ChildCryEvent {

    public void weekUp(){
        System.out.println("child cry");
        notifyListener();
    }

}
