package com.jary.progress.common.java8.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author fanzhengjie
 * @create 2018/8/25 下午1:40
 * @description 数值流：IntStream、LongStream、DoubleStream
 */
public class IntStreamTest {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1,100)
            .filter(n -> n%2==0);
        System.out.println(intStream.count());
    }
}
