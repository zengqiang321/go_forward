package com.jack.jdk8.lambda;

import java.util.function.*;

/**
 * 方法引用分类:
 * 类型                       语法                                          对应的Lambada 表达式
 * 静态方法引用        类名::staticMethoc                       (args)-> 类名.staticMethod(args)
 * 实例方法引用       inst::instMethod                            (args)->inst.instMethod(args)
 * 对象方法引用       类名::instMethod                          (inst.args)->类名.instMehtod(args)
 * 构造方法引用       类名::new                                     (args)->new 类名(args)
 *
 * 对象方法引用:抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数恰好可以当作实例方法的参数。
 * 如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法用。----一脸懵逼
 *
 * Created by manchong on 2020/5/23.
 */
public class T5 {

    public static String getVal(){
        return "T5";
    }

    public static String getVal2(String val) {
        return "T5_"+val;
    }

    public static void main(String[] args) {
        //静态方法调用
        System.out.println(getVal());

        Supplier<String> s1=()->getVal();
        System.out.println(s1.get());

        Supplier<String> s2=T5::getVal;
        System.out.println(s2.get());

        Supplier<String> s3=Fun::hello;
        System.out.println(s3.get());

        Function<String,String> fun=T5::getVal2;
        System.out.println(fun.apply("123"));

        Function<String,String> fun1=(a)->getVal2(a);
        System.out.println(fun1.apply("1234"));

        BiFunction<String,String,Integer> biFunction = (param1,param2)->param1.length()+param2.length();
        System.out.println(biFunction.apply("abc", "efg"));

        BiFunction<String,String,Integer> biFunction1 =Fun::getLenth;
        System.out.println(biFunction1.apply("abc","efg"));

        //实例对象调用
        System.out.println(new Fun().nonStaticMethod1());
        Supplier<String> s4=()->new Fun().nonStaticMethod1();
        System.out.println(s4.get());
        Supplier<String> s5=new Fun()::nonStaticMethod1;
        System.out.println(s5.get());

        Fun fun2=new Fun();
        Supplier<String> s6=fun2::nonStaticMethod1;
        System.out.println(s6.get());

        //对象方法引用
        //1.第一个参数类型是实例方法的类型
        Consumer<Too> c1=(Too too)->new Too().foo();
        c1.accept(new Too());

        Consumer<Too> c2=(Too too)->too.foo();
        c2.accept(new Too());

        Consumer<Too> c4=Too::foo;
        c4.accept(new Too());

        Consumer<Too> c3=(Too too)->new Too2().foo2();
        c3.accept(new Too());

        BiConsumer<Too2,String> c5=(too2,str)->too2.to2(str);
        c5.accept(new Too2(),"abc");

        BiConsumer<Too2,String> c6=Too2::to2;
        c6.accept(new Too2(),"sdf");

    }

}

class Too {
    public Integer to1(String s){
        System.out.println(s);
        return 1;
    }

    public void foo() {
        System.out.println("foo");
    }
}


class Too2 {
    public Integer to2(String s){
        System.out.println(s);
        return 1;
    }

    public void foo2() {
        System.out.println("foo2");
    }
}

class Fun{

    public String nonStaticMethod1(){
        return "nonStaticMethod1";
    }

    public static String hello(){
        return "hello";
    }

    public static Integer getLenth(String val1,String val2) {
        return val1.length()+val2.length();
    }
}
