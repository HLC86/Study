package com.my.generics;

/**
 * Created by u0149852 on 10/07/2014.
 */
public class TwoTuple<A,B> {
    private A a;
    private B b;

    public TwoTuple(A a, B b){
        this.a=a;
        this.b=b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }
}

class ThreeTuple<A,B,C> extends  TwoTuple<A,B>{
    private C c;
    public ThreeTuple(A a, B b, C c){
        super(a,b);
        this.c=c;
    }
}