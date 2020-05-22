package com.jack.design.create.build.build5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 假设现在有一个快餐店，其中销量最好的一款套餐就是一个汉堡和一杯饮料。
 * 汉堡分类 ：
 *  有素食汉堡（veg Burger）和鸡肉汉堡（Chicken Burger）
 * 饮料分类:
 *  饮料有可口可乐（coke）和百事可乐（pepsi）

 * Created by manchong on 2020/4/21.
 */
public class Client {


    public static void main(String[] args) {
        MealDirector director = new MealDirector();
        director.setBurger(new VegBurger()).setDrink(new Coke());
        director.showItems();

        director.setBurger(new ChickenBurger()).setDrink(new Coke());
        director.showItems();

        director.setBurger(new ChickenBurger()).setDrink(new Pepsl());
        director.showItems();

        Map<String,Integer> test  = new ConcurrentHashMap<>();
        test.put("1",1);
        test.put("2",2);
        test.put("3",3);
        test.put("4",4);
        test.put("3",4);
        test.remove("3");

    }


}
