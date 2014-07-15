package com.my.generics;

/**
 * Created by u0149852 on 10/07/2014.
 */
public class SimpleGenerics<T> {
    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    private T a;

    public static void main(String[] args){
        SimpleGenerics<String> sg=new SimpleGenerics<String>();
        sg.setA("aaaaaaaaa");
        String s = sg.getA();
        System.out.println(s);
    }
}
