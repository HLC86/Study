package com.my.generics;

/**
 * Created by u0149852 on 10/07/2014.
 */

class  A{
    public void test(){
        System.out.println("A::test");
    }
}

class  B{
    public void test(){
        System.out.println("B::test");
    }
}

public class Main {
    public TwoTuple<A,B> test(){
        A a = new A();
        B b= new B();
        return new TwoTuple<A, B>(a,b);
    }

    public  static void main(String[] args){
        TwoTuple<A,B> tt = new Main().test();
        tt.getA().test();
        tt.getB().test();
    }
}
