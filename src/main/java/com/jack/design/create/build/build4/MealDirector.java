package com.jack.design.create.build.build4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2020/4/21.
 */
public class MealDirector {

    private List<Item> items= new ArrayList<>();

    public  List<Item> addItem(Item item) {
        items.add(item);
        return items;
    }

    public void showItems(){
        BigDecimal cos = BigDecimal.ZERO;
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
            cos=cos.add(item.price());
        }
        System.out.println(",总价:"+cos);
        items.clear();
        System.out.println("------------------");
    }

}
