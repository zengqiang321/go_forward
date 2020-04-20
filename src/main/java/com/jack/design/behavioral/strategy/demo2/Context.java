package com.jack.design.behavioral.strategy.demo2;

/**
 * Created by manchong on 2020/4/20.
 */
public class Context {

    final static Flyweight flyweight = new Flyweight();

    public Context() {
        Promotion p = new OrderPromotion();
        Promotion p1 = new CartPromotion();

        flyweight.addPromotion(p);
        flyweight.addPromotion(p1);
    }

    public Promote action(String strategy){
        Promote promote= flyweight.getPromotion(strategy).getPromote();
        System.out.println(promote.toString());
        return promote;
    }


}
