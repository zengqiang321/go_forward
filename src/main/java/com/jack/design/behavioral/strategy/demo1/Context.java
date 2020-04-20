package com.jack.design.behavioral.strategy.demo1;

/**
 * Created by manchong on 2020/4/20.
 */
public class Context {

    private Promotion promotion;

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promote action(){
        Promote promote= promotion.getPromote();
        System.out.println(promote.toString());
        return promote;
    }

}
