package com.jack.design.create.singleton;

/**
 * Created by manchong on 2020/4/6.
 */
public class T2 {

    private int i=9;
    private static volatile T2 t=null; //多线程并发情况下。若没有volatile 修饰，会出现T2实例只是半初始化. 即i=0  而不是9，
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
