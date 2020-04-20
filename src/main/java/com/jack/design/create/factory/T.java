package com.jack.design.create.factory;

/**
 * Created by manchong on 2020/4/7.
 */
public class T {

    public static void main(String[] args) {
        AbstractFactory factory = new MCartMethodFactory();
        factory.getCart().brand();


        factory = new WCartMethodFactory();
        factory.getCart().brand();
    }


}
