package com.jary.progress.juc.thread.condition;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanzhengjie
 * @create 2019/1/16 上午11:36
 * @description https://www.cnblogs.com/Kevin-mao/p/5950758.html
 */
public class Demo3 {

    static class Storage{
        //仓库最大存储量
        private static final int MAX_SIZE = 100;

        //仓库存储的载体
        private static List<String> list = new LinkedList<>();

        //锁
        private final Lock lock = new ReentrantLock();

        //仓库满的条件变量
        private final Condition full = lock.newCondition();

        //仓库空的条件变量
        private final Condition empty = lock.newCondition();

        //生产num个产品
        public void produce(int num){
            lock.lock();
            try{
                // 如果仓库剩余容量不足
                while (list.size() + num > MAX_SIZE){
                    System.out.println("【要生产的产品数量】:" + num + "【库存量】:" + list.size()+ "暂时不能执行生产任务!");
                    try {
                        full.await();// 由于条件不满足，生产阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 生产条件满足情况下，生产num个产品
                for(int i=0;i<num;i++){
                    list.add(i+"");
                }

                System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());

                // 唤醒其他所有线程
                full.signalAll();
                empty.signalAll();
            }finally {
                lock.unlock();
            }
        }

        // 消费num个产品
        public void consume(int num){
            lock.lock();
            try{
                // 如果仓库存储量不足
                while (list.size() < num){
                    System.out.println("【要消费的产品数量】:" + num + "【库存量】:" + list.size()+ "暂时不能执行消费任务!");
                    try{
                        // 由于条件不满足，消费阻塞
                        empty.await();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                // 消费条件满足情况下，消费num个产品
                for (int i = 0; i < num; i++){
                    list.remove(i+"");
                }

                System.out.println("【已经消费产品数】:" + num + "【现仓储量为】:" + list.size());

                // 唤醒其他所有线程
                full.signalAll();
                empty.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public static int getMaxSize() {
            return MAX_SIZE;
        }

        public static List<String> getList() {
            return list;
        }

        public static void setList(List<String> list) {
            Storage.list = list;
        }
    }

    static class Producer extends Thread{
        // 每次生产的产品数量
        private int num;

        // 所在放置的仓库
        private Storage storage;

        // 构造函数，设置仓库
        public Producer(Storage storage){
            this.storage = storage;
        }

        // 线程run函数
        @Override
        public void run(){
            produce(num);
        }

        // 调用仓库Storage的生产函数
        public void produce(int num){
            storage.produce(num);
        }

        // get/set方法
        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }

        public Storage getStorage()
        {
            return storage;
        }

        public void setStorage(Storage storage)
        {
            this.storage = storage;
        }
    }

    static class Consumer extends Thread {
        // 每次消费的产品数量
        private int num;

        // 所在放置的仓库
        private Storage storage;

        // 构造函数，设置仓库
        public Consumer(Storage storage){
            this.storage = storage;
        }

        // 线程run函数
        public void run(){
            consume(num);
        }

        // 调用仓库Storage的生产函数
        public void consume(int num){
            storage.consume(num);
        }

        // get/set方法
        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }

        public Storage getStorage()
        {
            return storage;
        }

        public void setStorage(Storage storage)
        {
            this.storage = storage;
        }
    }

    public static void main(String[] args) {
        // 仓库对象
        Storage storage = new Storage();

        // 生产者对象
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);
        Producer p7 = new Producer(storage);

        // 消费者对象
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
        Consumer c3 = new Consumer(storage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }


}
