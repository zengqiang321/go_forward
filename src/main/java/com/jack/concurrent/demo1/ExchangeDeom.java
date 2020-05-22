package com.jack.concurrent.demo1;

import java.util.concurrent.Exchanger;

/**
 * Created by manchong on 2020/5/21.
 */
public class ExchangeDeom {

    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger();
         new Thread(()->{
            try {
               String v= ex.exchange("threadA exchange name");
                System.out.println("thread a get value:"+v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
               String v= ex.exchange("thread b exchange dddd");
                System.out.println("thread b get value:"+v);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
