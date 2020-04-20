package com.jack.design.behavioral.observer.demo2;

/**
 * Created by manchong on 2020/4/9.
 */
public class Did implements ChildCryListener {

    @Override
    public void babyCry(ChildCryEvent event) {
        System.out.println("did hugging====arg:"+event);
    }
}
