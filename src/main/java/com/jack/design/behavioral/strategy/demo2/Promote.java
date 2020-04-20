package com.jack.design.behavioral.strategy.demo2;

/**
 * Created by manchong on 2020/4/7.
 */
public class Promote {
    String p;

    public Promote(String p){
        this.p=p;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Promote{" +
                "p='" + p + '\'' +
                '}';
    }
}
