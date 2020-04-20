package com.jack.design.create.build;

/**
 * Created by manchong on 2020/4/8.
 */
public class T {

    public static void main(String[] args) {
        Builder builder = new BenCarBuilder();
        builder.setCarWheel("ben cart bulder");
        builder.setCarHead("ben cart head");

        Director director = new Director(builder);
        director.createCar();

    }

}
