package com.jack.design.behavioral.strategy.demo2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by manchong on 2020/4/20.
 */
public class Flyweight {

    private Map<String,Promotion> promotions = new HashMap<>();

    public void addPromotion(Promotion promotion) {
         promotions.put(promotion.getStrategyName().toUpperCase(),promotion);
    }

    public Promotion getPromotion(String strategy){
        return promotions.get(strategy.toUpperCase());
    }

}
