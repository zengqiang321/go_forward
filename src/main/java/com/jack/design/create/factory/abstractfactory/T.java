package com.jack.design.create.factory.abstractfactory;

/**
 * Created by manchong on 2020/4/7.
 */
public class T {

    public static void main(String[] args) {

        //得到W系列的产品

        AbFactory f= new WFactory();
        Cart cart=f.getCart();
        System.out.println(cart.getCartName());

        Food food =f.getFood();
        System.out.println(food.getName());


        //得到m系列的产品

        AbFactory m= new MFactory();
        Cart mcart=f.getCart();
        System.out.println(mcart.getCartName());

        Food fmood =f.getFood();
        System.out.println(fmood.getName());


    }

}
