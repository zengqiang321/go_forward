package com.jack.design.structural.decorator.decorator;

import java.math.BigDecimal;

/**
 * Created by manchong on 2020/4/13.
 */
public class SugarTeaMilkDecator  extends AbstractTeaMilkDecator {

    public SugarTeaMilkDecator(TeaMilk teaMilk) {
        super(teaMilk);
    }

    @Override
    public String name() {
        String msg=super.name();
        StringBuilder sb = new StringBuilder(msg);
        sb.append("\t").append("add sugar");

        return sb.toString();
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(BigDecimal.valueOf(5.0D)); //加糖5元
    }
}
