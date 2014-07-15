package com.my.exceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by u0149852 on 15/07/2014.
 */
public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public  static  void main(String[] args){
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            executor.execute(new ExceptionThread());
        }
        catch (RuntimeException e){
            System.out.println("Dang dang dang");
        }
    }
}
