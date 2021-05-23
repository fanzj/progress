package com.jary.progress.common.java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author fanzhengjie
 * @create 2018/8/25 下午1:40
 * @description 数值流：IntStream、LongStream、DoubleStream
 */
public class TestIntStream {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(intStream.count());

        gougushu();

    }

    private static void gougushu() {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
