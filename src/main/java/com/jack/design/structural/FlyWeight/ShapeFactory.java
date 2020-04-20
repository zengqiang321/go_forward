package com.jack.design.structural.FlyWeight;


import java.util.HashMap;

/**
 * Created by jingbin on 2020-02-01.
 * 3. 创建一个工厂，生成基于给定信息的实体类的对象。
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

    static {
        String[] colors = {"red","black"};
        for (String s :colors) {
            circleMap.put(s,new Circle(s));
        }
    }

    public static Shape getShape(String color) {
        Shape shape = circleMap.get(color);
        return shape;
    }

}
