package com.jack.design.behavioral.strategy.demo2;

/**
 * Created by manchong on 2020/4/7.
 */
public interface Promotion {

    Promote getPromote();

    boolean isSupport(String strategy);

    String getStrategyName();

}
