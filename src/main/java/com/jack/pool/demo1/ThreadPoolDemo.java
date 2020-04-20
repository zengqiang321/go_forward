package com.jack.pool.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by manchong on 2020/readme/7.
 */
public class ThreadPoolDemo {

    final static ExecutorService exec = new ThreadPoolExecutor(5,5,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>());


    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();
        int task =100000;
        int part=task/500;
        CompletionService<Integer> completionService = new ExecutorCompletionService(exec);
        for (int i=0;i<500;i++){
            int from=i*part;
            int to=from+part;
            completionService.submit(new Task(from,to));
        }

        int total=0;
        for (int i=0;i<500;i++) {
            total += completionService.take().get();
        }

        System.out.println(total+"==="+(System.currentTimeMillis()-start));

    }

    public static class Task implements Callable<Integer> {

        private int from;
        private int to;

        public Task(int from,int to) {
            this.from =from;
            this.to=to;
        }

        @Override
        public Integer call() {
            int res=0;
            for (int i=from;i<to;i++){
                res += i;
            }
            return res;
        }
    }


}
