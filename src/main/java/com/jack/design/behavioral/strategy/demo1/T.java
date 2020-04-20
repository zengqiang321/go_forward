package com.jack.design.behavioral.strategy.demo1;

/**
 * Created by manchong on 2020/4/7.
 */
public class T {
    public static void main(String[] args) {
        Promotion p = new OrderPromotion();
//        Promotion p = new CartPromotion();
        Promote promote = p.getPromote();
        System.out.println(promote.toString());




        Context context = new Context();
        context.setPromotion(new OrderPromotion());
        context.action();


        context.setPromotion(new CartPromotion());
        context.action();



    }
}
