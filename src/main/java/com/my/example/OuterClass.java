package com.my.example;

/**
 * Created by U0149852 on 14/07/2014.
 */
public class OuterClass {
    public class InnerClass{
        public void test(){

            System.out.println("inner::test");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public InnerClass get(){
        return  new InnerClass();
    }

    protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("outer destoryed");
    }
}
