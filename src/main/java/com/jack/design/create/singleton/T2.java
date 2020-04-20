package com.jack.design.create.singleton;

/**
 * Created by manchong on 2020/4/6.
 */
public class T2 {

    private static volatile T2 t=null;
    private T2(){}

    public static T2 instance(){
        if(t==null) {
            synchronized (t) {
                if(t==null){
                    return t;
                }
                t=new T2();
            }
        }
        return t;
    }

}
