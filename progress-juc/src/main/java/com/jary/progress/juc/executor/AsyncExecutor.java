package com.jary.progress.juc.executor;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @date 2020/5/17 7:58 下午
 */
public class AsyncExecutor {

    private static final Logger log = LoggerFactory.getLogger(AsyncExecutor.class);

    /**
     * 当前cpu核心数
     */
    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    /**
     * 拒绝策略：如果添加到线程池失败，主线程会自己去执行该任务
     * 1、AbortPolicy 丢弃任务并抛出RejectedExecutionException异常
     * 2、CallerRunsPolicy 由调用线程处理该任务
     * 3、DiscardOldestPolicy 丢弃队列最前面的任务，然后重新提交被拒绝的任务。
     * 4、DiscardPolicy 丢弃任务，但是不抛出异常。如果线程队列已满，则后续提交的任务都会被丢弃，且是静默丢弃。
     */
    private static RejectedExecutionHandler REJECT = new ThreadPoolExecutor.CallerRunsPolicy();

    /**
     * 采用LinkedBlockingQueue作为等待队列，生产和消费的锁是分离的，比较适合请求和执行频率差不多的场景
     */
    private static LinkedBlockingQueue<Runnable> QUEUE = new LinkedBlockingQueue<>();

    private static ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder()
            .setNameFormat("progress-executor-%s")
            .setUncaughtExceptionHandler((t, e) -> log.error("progress线程池未知异常, threadName:{}", t.getName(), e))
            .build();

    /**
     * 假设一个请求平均执行时间为10ms，则单线程一秒钟能执行100个请求（有IO等待或者强制阻塞的不考虑）
     * 此线程池被用于pay-service所有场景，假设异步的场景最高并发量为400，则峰值的时候最少需要4线程
     * cpu资源足够的情况，维持cpu核心数的核心线程数，cpu+max并发量的最大线程数
     */
    private static ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE + 4, 30, TimeUnit.SECONDS, QUEUE, THREAD_FACTORY
            , REJECT);

    public static ExecutorService getExecutorService() {
        return EXECUTOR_SERVICE;
    }
}


