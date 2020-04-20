package com.jack.design.structural.decorator.decorator;

/**
 * Created by manchong on 2020/4/13.
 */
public class Main {

    public static void main(String[] args) {
        TeaMilk teaMilk = new CoofeeTeaMilk();
        teaMilk = new SugarTeaMilkDecator(new MilkTeaMilkDecator(teaMilk));//加糖+奶
        System.out.println(teaMilk.name()+"===价格："+teaMilk.getPrice());

        TeaMilk cooskin = new CooskinMilkTea();
        cooskin = new SugarTeaMilkDecator(new MilkTeaMilkDecator(cooskin));//加糖+奶
        System.out.println(cooskin.name()+"===价格："+cooskin.getPrice());


    }

}
