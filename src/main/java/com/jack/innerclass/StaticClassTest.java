package com.jack.innerclass;

/**
 * Created by manchong on 2020/4/24.
 */
public class StaticClassTest {

    public static void main(String[] args) {
        //直接调用类的静态属性，类只是对静态属性，静态代码块进行了初始化，并没有对类进行初始化
//        System.out.println(StaticClass.OUTER_DATE);
        //直接调用类的静态内部类，外部类的静态属性，静态代码块没有初始化。只有静态类的静态属性，静态代码块没有初始化
        System.out.println(StaticClass.InnerStaticClass.INNER_STATIC_DATE);

        //实例化静态内部类，外部类的静态属性，静态代码块没有初始化。如果静态内部变量已经被访问，静态块不再初始化
//        StaticClass.InnerStaticClass n=new StaticClass.InnerStaticClass();

        //
//        StaticClass staticClass = new StaticClass();
//        System.out.println(staticClass.innerClass);
//        StaticClass.InnerClass innerClass =staticClass.new InnerClass();

    }

}
