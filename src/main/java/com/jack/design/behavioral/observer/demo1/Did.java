package com.jack.design.behavioral.observer.demo1;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by manchong on 2020/4/9.
 */
public class Did implements Observer {

    //注册观察者
    public Did (Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println("did hugging====arg:"+arg);
    }
}
