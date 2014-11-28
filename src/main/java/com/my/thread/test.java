package com.my.thread;

import java.util.concurrent.*;

/**
 * Created by Xiaoming Wang on 2014/10/24.
 */
public class test {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(10));
        for (int i = 0; i < 5; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ThreadLocalRandom.current().nextInt(100));
                }
            });
        }
        threadPool.shutdown();
    }
}
