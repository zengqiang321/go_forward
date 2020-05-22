package com.jack.design.create.build.build5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/4/21.
 */
public class MealDirector {

    private Item burger;
    private Item drink;

    public MealDirector setBurger(Item burger) {
        this.burger = burger;
        return this;
    }

    public MealDirector setDrink(Item drink) {
        this.drink = drink;
        return this;
    }

    public void showItems(){

        BigDecimal cos = BigDecimal.ZERO;
        System.out.print("Item : "+burger.name());
        System.out.print(", Packing : "+burger.packing().pack());
        System.out.println(", Price : "+burger.price());
        cos=cos.add(burger.price());


        System.out.print("Item : "+drink.name());
        System.out.print(", Packing : "+drink.packing().pack());
        System.out.println(", Price : "+drink.price());
        cos=cos.add(burger.price());

        System.out.println(",总价:"+cos);

        System.out.println("------------------");
    }

}
