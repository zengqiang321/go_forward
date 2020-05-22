package com.jack.concurrent.demo1;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by manchong on 2020/4/23.
 */
public class WithOutValatile {

   volatile List<String> list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        WithOutValatile valatile = new WithOutValatile();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
                while (true) {

                    if(valatile.list.size()==5) {
                        break;
                    }
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    valatile.list.add(""+i);
                    System.out.println(i);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }).start();



    }




}
