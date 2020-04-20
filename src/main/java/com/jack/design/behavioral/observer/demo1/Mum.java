package com.jack.design.behavioral.observer.demo1;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by manchong on 2020/4/9.
 */
public class Mum implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println("mum sound===arg="+arg);
    }
}
