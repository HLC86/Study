package com.my.exceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by u0149852 on 15/07/2014.
 */
public class ExceptionThread2 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("my UncaughtExceptionHandler " + e);
                    }
                });
                return t;
            }
        });
        exec.execute(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                System.out.println("Run:" + t);
                System.out.println("eh= " + t.getUncaughtExceptionHandler());
                throw new RuntimeException();
            }
        });
    }
}
