package com.jary.progress.juc.thread.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

/**
 * @author fanzhengjie
 * @create 2019/8/28 下午8:21
 * @description
 */
public class AsyncExecutor {

    private static final Logger log = LoggerFactory.getLogger(AsyncExecutor.class);

    //当前cpu核心数
    private static final int coreSize = Runtime.getRuntime().availableProcessors();

    //如果添加到线程池失败，主线程会自己去执行该任务
    private static RejectedExecutionHandler reject = new CallerRunsPolicy();

    //采用LinkedBlockingQueue作为等待队列，生产和消费的锁是分离的，比较适合请求和执行频率差不多的场景
    private static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
        .setNameFormat("daily-executor-%s")
        .setUncaughtExceptionHandler((t, e) -> log.error("daily线程池未知异常, threadName:{}", t.getName(), e))
        .build();

    //假设一个请求平均执行时间为10ms，则单线程一秒钟能执行100个请求（有IO等待或者强制阻塞的不考虑）
    //此线程池被用于pay-service所有场景，假设异步的场景最高并发量为400，则峰值的时候最少需要4线程
    //cpu资源足够的情况，维持cpu核心数的核心线程数，cpu+max并发量的最大线程数
    private static ExecutorService executorService = new ThreadPoolExecutor(coreSize, coreSize + 4,
        30, TimeUnit.SECONDS, queue, threadFactory, reject);

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static void main(String[] args) {


    }

}
