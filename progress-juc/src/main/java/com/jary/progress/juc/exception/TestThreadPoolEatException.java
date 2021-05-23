package com.jary.progress.juc.exception;

import java.util.concurrent.*;

/**
 * @author fanzhengjie
 * @create 2018/11/16 上午11:16
 * @description
 */
public class TestThreadPoolEatException {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 0, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());
        for(int i=0; i<3; i++) {
            // 无法打印堆栈信息
            threadPool.submit(new DivTask(99, i));
        }
        /*ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 0, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

        for(int i=0; i<3; i++) {
            Future future = threadPool.submit(new DivTask(99, i));
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/

       /* ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 10, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i = 0; i < 3; i++) {
            // 可以打印出堆栈信息
            threadPool.execute(new DivTask(99, i));
        }*/
    }
}
