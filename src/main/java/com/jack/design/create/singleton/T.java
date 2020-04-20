package com.jack.design.create.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/4/6.
 */
public class T {


    private final static T t = new T();

    private T(){}

    public static T instance(){
        return t;
    }

}
