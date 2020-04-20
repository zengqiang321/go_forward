package com.jack.design.create.singleton;

/**
 * Created by manchong on 2020/4/6.
 */
public enum  T3 {

    instance;

    public static T3 instance(){
        return T3.instance();
    }

}
