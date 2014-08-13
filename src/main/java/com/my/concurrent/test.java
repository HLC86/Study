package com.my.concurrent;

import java.util.LinkedHashMap;

/**
 * Created by u0149852 on 2014/8/6.
 */
public class test {
    public static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>() {{
            put("1", 1);
        put("2", 2);
        put("3", 3);
    }};
    public static void main(String[] args){
        for(int i =0;i<10;i++){
            new Thread(new Runnable() {
                public void run() {
                    for(String key : test.map.keySet()){
                        System.out.println(test.map.get(key));
                    }
                }
            }).start();
        }
    }
}
