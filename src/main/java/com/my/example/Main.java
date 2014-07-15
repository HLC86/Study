package com.my.example;

public class Main {

    public static void main(String[] args) throws Exception {
        Tester t = new Tester();
        OuterClass out = new OuterClass();
        OuterClass.InnerClass innerClass = out.get();
        t = null;
        out = null;
        System.gc();
        innerClass.test();
//
//        if (args.length > 0 && "stop".equals(args[0])) {
//            System.out.println("stopped");
//            System.exit(0);
//        } else {
//            System.out.println("Hello maven");
//            //1
//            //2
//            System.out.println();
//
//        }
//
//        ok:
//        	for(int i =0;i<10;i++){
//        		System.out.println(i);
//        		for(int j=0;j<10;j++){
//        			System.out.print(j);
//        			break ok;
//        		}
//        	}
    }

}
