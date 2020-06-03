package com.jack.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by manchong on 2020/5/29.
 */
public class T2 {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        withThreadPool(10);
    }


    public static void withThreadPool(int c){
        for(int i=0;i<c;i++){
            Integer var1 = (int)(Math.random()*100);
            Integer var2 = (int)(Math.random()*100);
            MyContextHolder.set(var1);
            threadPoolExecute(var1,var2);
        }
    }


    public static void threadPoolExecute(Integer var1,Integer var2){
        executorService.execute(()->assert1(var1,var2));
    }


    public static void assert1(Integer var1,Integer var2){
        System.out.println(MyContextHolder.get().equals(var1));
    }


    public static class MyContextHolder{

        private static ThreadLocal<Integer> stringThreadLocal = new InheritableThreadLocal<>();

        public static void set(Integer data) {
            stringThreadLocal.set(data);
        }

        public static Integer get() {
            return stringThreadLocal.get();
        }
    }


}
