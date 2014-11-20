package com.my.designpattern.singleton;

public class Singleton2 {

    private Singleton2() {

    }

    private static class SingletonFactory {
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String[] args) {
        Singleton3 instance1 = Singleton3.INSTANCE;
        Singleton3 instance2 = Singleton3.INSTANCE;
        instance1.setName("hi");
        System.out.print(instance2.getName());
    }
}

enum Singleton3 {
    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
