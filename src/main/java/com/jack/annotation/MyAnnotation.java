package com.jack.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Created by manchong on 2020/5/24.
 */

public class MyAnnotation {

    @MyAnn("abc")
    private String name;



    public static void main(String[] args) throws IllegalAccessException {
        MyAnnotation annotation = new MyAnnotation();
        annotation.ann();
        System.out.println(annotation.name);
    }


    public  void ann() throws IllegalAccessException {

        Class aClass = MyAnnotation.class;

        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(MyAnn.class)) {
                MyAnn annotation = field.getAnnotation(MyAnn.class);
                String val=annotation.value();
                System.out.println(val);
                field.setAccessible(true);
                field.set("name",val);
            }
        }

    }

}





//定义使用在类那些元素上
@Target({ElementType.FIELD})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Inherited 代表是否可以被继承
@interface MyAnn {
    String value();
}
