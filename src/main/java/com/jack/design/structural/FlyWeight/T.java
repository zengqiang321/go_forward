package com.jack.design.structural.FlyWeight;

/**
 * Created by manchong on 2020/4/10.
 */
public class T {

    public static void main(String[] args) {

        Circle shape =(Circle) ShapeFactory.getShape("red");
        shape.setRadius(1);
        shape.setX(2);
        shape.setY(3);
        shape.draw();

        System.out.println(System.getProperties());
        System.out.println("====");
        System.out.println(System.getenv());



    }

}
