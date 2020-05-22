package com.jack.jvm;

/**
 * -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+PrintFlagsFinal -XX:+PrintVMOptions -
 * Created by manchong on 2020/5/14.
 */
public class ArthasDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            byte[] b = new byte[1024 * 1024];
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
