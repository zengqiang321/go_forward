package com.jack.jdk8.lambda;

import java.util.concurrent.Callable;

/**
 * lamada支持的语法:
 * ()->{}
 * ()->System.out.println("ddddd");//打印ddddd
 * (x)->{} //输出参数x
 * (x,y)->{return x+y;} ////返回x+y的值
 * (x,y)->x+y;  //返回x+y的值
 * Created by manchong on 2020/5/23.
 */
public class T {

    public static void main(String[] args) throws Exception {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1");
            }
        };
        runnable1.run();


        Runnable runnable2 = ()->{
            System.out.println("runnable2");
        };
        runnable2.run();


        Runnable runnable3 =()-> System.out.println("runnable3");
        runnable3.run();

        Callable callable =()->{return "dddd";};
        System.out.println(callable.call());

        Callable callable1=()->"callable3";
        System.out.println(callable1.call());

    }

}
