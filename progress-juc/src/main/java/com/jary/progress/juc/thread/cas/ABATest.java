package com.jary.progress.juc.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author fanzhengjie
 * @create 2020/3/2 上午10:35
 * @description
 */
public class ABATest {


    public static void main(String[] args) throws InterruptedException {
        //ABA问题
        //atomicIntegerTest();

        //解决ABA问题
        atomicStampedReferenceTest();
    }

    private static void atomicIntegerTest() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.compareAndSet(100,101);
                atomicInteger.compareAndSet(101,100);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean c = atomicInteger.compareAndSet(100, 101);
                System.out.println(c);
            }
        });
        t1.start();
        t2.start();
    }

    public static void atomicStampedReferenceTest(){
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 0);
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        });

        Thread t2 = new Thread(() -> {
           int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean c = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(c);
        });
        t1.start();
        t2.start();
    }
}
