package com.jack.design.structural.birdge;

/**
 * Created by manchong on 2020/4/8.
 */
public abstract class AbstractPhone implements Phone  {
    protected Brand brand;
    public AbstractPhone(Brand brand){
        this.brand = brand;
    }


    @Override
    public void call() {
        System.out.print(brand.brandName());
    }
}
