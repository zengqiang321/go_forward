package com.jack.design.create.factory;

/**
 * Created by manchong on 2020/4/7.
 */
public class SimpleFactory  {

    public Cart getWCart() {
        System.out.println("在返回WCart前做xxxx休息");
        return new WCart();
    }

    public Cart getMCart() {
        System.out.println("在返回MCart前做xxxx休息");
        return new MCart();
    }



}
