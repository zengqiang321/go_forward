package com.jack.design.create.singleton;

/**
 * Created by manchong on 2020/4/6.
 */
public class T1 {

    private static class TiHolder{
        private final static T1 t = new T1();
    }

    private T1(){}

    public static T1 instance(){
        return TiHolder.t;
    }

}
