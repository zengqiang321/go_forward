package com.jack.design.behavioral.observer.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/4/19.
 */
public class ChildCryEvent  {
    List<ChildCryListener> listeners = new ArrayList<>();
    public void addEventListener(ChildCryListener listener){
        listeners.add(listener);
    }

   public void notifyListener(){
        for (ChildCryListener listener : listeners) {
            listener.babyCry(this);
        }
    }

}
