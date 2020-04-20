package com.jack.concurrent;

import java.util.concurrent.*;

/**
 * Created by manchong on 2019/12/27.
 */
public class CallableRunableFutureTaskTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread thread = new Thread( new RunnableImpl());
        thread.start();

        Future<?> future=Executors.newSingleThreadExecutor().submit(new RunnableImpl());
        System.out.println((String)future.get());
        System.out.println(future.isDone());

    }

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static Future<Integer> calculate(Integer input) {
        return executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return input * input;
            }
        });

    }


    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("I'm running");
        }
    }


    public static class CallableImpl implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Callable Return Result Value";
        }
    }
}
