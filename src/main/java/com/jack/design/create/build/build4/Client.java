package com.jack.design.create.build.build4;

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

        director.addItem(new VegBurger()).add(new Coke());
        director.showItems();

        director.addItem(new ChickenBurger()).add(new Coke());
        director.showItems();


        director.addItem(new ChickenBurger()).add(new Pepsl());
        director.showItems();


    }


}
