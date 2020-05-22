package com.jack.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdder为什么高效， LongAdder内部使用了分段锁概念。
 * 所以在线程数特别多的情况下，LongAdder比Atomic性能高。
 * 最后调用sum()聚会结果
 * Created by manchong on 2020/5/21.
 */
public class LongAdderTest {

    public static AtomicLong count1= new AtomicLong(0);
    public static LongAdder count2 = new LongAdder();

    public static void main(String[] args) throws Exception {

        List<Thread> list = new ArrayList();
        long time = System.currentTimeMillis();
        for(int i=0;i<10;i++) {
          Thread t=  new Thread(() -> {
                for (int k = 0; k< 10000; k++) {
                    count1.incrementAndGet();
                }
            });
          list.add(t);
        }

        for (Thread t: list) {
                t.start();
        }
        for (Thread t:list) {
            t.join();
        }
        System.out.println(System.currentTimeMillis()-time);

        long tim2 = System.currentTimeMillis();
        List<Thread> list2 = new ArrayList<>();
        for(int i=0;i<10;i++) {
            Thread t2 = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    count2.increment();
                }
            });
            list2.add(t2);
        }

        for (Thread t:list2){t.start();}
        for (Thread t:list2){t.join();}
        count2.sum();
        System.out.println(System.currentTimeMillis()-tim2);


    }



}
