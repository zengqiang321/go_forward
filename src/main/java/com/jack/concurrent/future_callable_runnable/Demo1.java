package com.jack.concurrent.future_callable_runnable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by manchong on 2020/4/24.
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {
        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "ddd";
            }
        };

        System.out.println(call.call());

        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
            }
        };

        new Thread(r).start();

        FutureTask<String> task = new FutureTask(call);

        new Thread(task).start();
        System.out.println(task.get());


        task = new FutureTask(r,"abc");

        new Thread(task).start();
        System.out.println(task.get());





    }

}
