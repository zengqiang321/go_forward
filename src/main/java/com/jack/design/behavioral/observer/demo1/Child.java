package com.jack.design.behavioral.observer.demo1;

import java.util.Observable;

/**
 * Created by manchong on 2020/4/9.
 */
public class Child extends Observable {

    public void weekUp(){
        System.out.println("child cry");
//        while (!cry) {
//            WakeUpEvent event = new WakeUpEvent();
//            addObserver(new Did());
        setChanged();
        notifyObservers("sdfsdfsd");
//        }

    }

}
