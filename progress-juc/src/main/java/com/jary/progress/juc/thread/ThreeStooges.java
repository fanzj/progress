package com.jary.progress.juc.thread;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanzhengjie
 * @create 2019/2/13 下午2:39
 * @description
 */
public final class ThreeStooges {

    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges(){
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
    }

    public boolean isStooge(String name){
        return stooges.contains(name);
    }

    public static void main(String[] args) {
        ThreeStooges threeStooges = new ThreeStooges();
        System.out.println(threeStooges.isStooge("Moe"));
    }
}
