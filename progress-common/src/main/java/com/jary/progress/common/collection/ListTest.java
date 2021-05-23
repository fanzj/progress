package com.jary.progress.common.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fanzhengjie
 * @create 2019/1/11 下午5:15
 * @description 如何用一行代码初始化一个ArrayList
 * https://github.com/giantray/stackoverflow-java-top-qa/blob/master/contents/initialization-of-an-arraylist-in-one-line.md
 */
public class ListTest {

    public static void main(String[] args) {
        method1();

        method2();
        method3();

        method4();


    }

    /**
     *
     */
    private static void method4() {
        List<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
        places.add("Beijing");
        System.out.println(places);
    }

    /**
     * 同method2
     */
    private static void method3() {
        List<String> list = Collections.singletonList("a");
        System.out.println(list);
    }

    /**
     * 得到的是一个定长的List(如果add操作会抛异常）
     */
    private static void method2() {
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(list);
        // list.add("d");
    }

    /**
     * 匿名内部类 例如,写一个匿名内部类，然后在其中做初始化
     */
    private static void method1() {
        List<String> list = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };
        System.out.println(list);
    }

}
