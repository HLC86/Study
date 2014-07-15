package com.my.example;

/**
 * Created by U0149852 on 14/07/2014.
 */
public class Tester {
    protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Tester destoryed");
    }

    public void run()
    {
        System.out.println("RUN");
    }
}
