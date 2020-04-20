package com.jack.design.create.build;

/**
 * Created by manchong on 2020/4/7.
 */
public class Car {

    private String setWheel;

    private String headstock;

    public String getSetWheel() {
        return setWheel;
    }

    public void setSetWheel(String setWheel) {
        this.setWheel = setWheel;
    }

    public String getHeadstock() {
        return headstock;
    }

    public void setHeadstock(String headstock) {
        this.headstock = headstock;
    }

    @Override
    public String toString() {
        return "Car{" +
                "setWheel='" + setWheel + '\'' +
                ", headstock='" + headstock + '\'' +
                '}';
    }
}
