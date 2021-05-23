package com.jary.progress.juc.thread.exception.demo1;

import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @create 2020/1/15 下午2:25
 * @description 线程池异常处理
 */
public class ExecutorPoolExceptionTest {

    public static void main(String[] args) {
        testException4();


    }

    /**
     * #法1: 在任务代码try/catch捕获异常
     */
    private static void testException1() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                try {
                    Object object = null;
                    System.out.print("result## " + object.toString());
                } catch (Exception e) {
                    System.out.println("run error: " + e);
                }
            });
        }
    }

    /**
     * #法2: 通过Future对象的get方法接收抛出的异常
     */
    private static void testException2() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 30, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

        for (int i = 0; i < 5; i++) {
            Future future = executor.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## " + object.toString());
            });

            try {
                future.get();
            } catch (Exception e) {
                System.out.println("exception: " + e);
            }
        }
    }

    /**
     * #法3: 为工作者线程设置UncaughtExceptionHandler，在uncaughtException方法中处理异常
     */
    private static void testException3() {
        ExecutorService executorService = Executors.newFixedThreadPool(1, r -> {
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler((t1, e) -> {
                    System.out.println(t1.getName() + "线程抛出的异常" + e);
                }
            );
            return t;
        });

        executorService.execute(() -> {
            for (int i = 0; i < 5; i++) {
                executorService.execute(() -> {
                    System.out.println("current thread name" + Thread.currentThread().getName());
                    Object object = null;
                    System.out.print("result## " + object.toString());
                });
            }
        });
    }

    /**
     * #法4: 重写ThreadPoolExecutor的afterExecute方法，处理传递的异常引用
     */
    private static void testException4() {
        ExtendedExecutor executor = new ExtendedExecutor(5, 5, 30, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## " + object.toString());
            });
        }
    }

    static class ExtendedExecutor extends ThreadPoolExecutor {

        public ExtendedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public ExtendedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        public ExtendedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        public ExtendedExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
            RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            System.out.println("线程执行后");
            if (t == null && r instanceof Future<?>) {
                try {
                    Object result = ((Future<?>) r).get();
                } catch (CancellationException ce) {
                    t = ce;
                } catch (ExecutionException ee) {
                    t = ee.getCause();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // ignore/reset
                }
            }
            if(t != null){
                System.out.println("异常: "+ t);
            }
        }
    }


}
