package com.jack.changeIntegerValue;

/**
 * Created by manchong on 2020/readme/6.
 */
public class T2 {
    private final T t= new T();

    public static void main(String[] args) {
        T2 t2 = new T2();
        T2 t22 = new T2();
        System.out.println(t2.t);
        System.out.println(t22.t);
        System.out.println(t2.t==t22.t);
    }
}
