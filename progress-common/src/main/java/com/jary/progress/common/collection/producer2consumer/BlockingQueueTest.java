package com.jary.progress.common.collection.producer2consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author fanzhengjie
 * @create 2019/1/11 下午3:43
 * @description
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        //声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);

        //执行10s
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);
        service.shutdown();
    }

}
