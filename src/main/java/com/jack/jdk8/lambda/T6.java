package com.jack.jdk8.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by manchong on 2020/5/23.
 */
public class T6 {
    public static void main(String[] args) {
        Supplier<Acc> s=()->new Acc();
        System.out.println("---");
        Acc acc = s.get();
        System.out.println("-=-=-=");
        Supplier<Acc> s2=Acc::new;
        System.out.println("-----");
        Acc acc1 = s2.get();
        System.out.println("----");

        Function<String,Acc> f1=Acc::new;
        Acc acc2 = f1.apply("asdf");


    }
}


class Acc{
    public Acc(){
        System.out.println("无参数构造调用");
    }
    public Acc(String s){
        System.out.println(s+" 有参数构造带哦用");
    }

}
