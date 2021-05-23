package com.jary.progress.common.java8.test;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author fanzhengjie
 * @create 2018/9/1 下午4:11
 * @description 并行流
 */
public class TestParallelStream {

    public static final Integer PROCESS_NUM = Runtime.getRuntime().availableProcessors();//处理器数量

    public static void main(String[] args) {
        //System.out.println("Sequential sum done in:" + measureSumPerf(TestParallelStream::sequentialSum, 10_000_000) + " msecs");
        //System.out.println("Iterative sum done in:" + measureSumPerf(TestParallelStream::iterativeSum, 10_000_000) + " msecs");
        //System.out.println("Parallel sum done in: " + measureSumPerf(TestParallelStream::parallelSum, 10_000_000) + " msecs" );

      //  System.out.println("Ranged sum done in: " + measureSumPerf(TestParallelStream::rangedSum, 10_000_000) + " msecs" );
        //System.out.println("Parallel range sum done in: " + measureSumPerf(TestParallelStream::parallelRangedSum, 10_000_000) + " msecs" );

    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.format("Result%02d: %d\n", i, sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .parallel()
            .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    //best
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(0L, Long::sum);
    }


}
