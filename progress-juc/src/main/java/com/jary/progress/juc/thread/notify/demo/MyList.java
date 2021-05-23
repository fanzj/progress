package com.jary.progress.juc.thread.notify.demo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author fanzhengjie
 * @create 2019/10/28 上午12:01
 * @description
 */
public class MyList {

    private static List<String> list= Lists.newArrayList();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }

}
