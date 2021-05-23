package com.jary.progress.juc.thread.interrupt;

import java.util.concurrent.locks.LockSupport;

/**
 * @author fanzhengjie
 * @create 2020/1/7 下午4:57
 * @description aqs acquireQueued 方法要么中断要么获取锁测试
 */
public class InterruptTest2 {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(new InterruptTest2().acquireQueued());
            }
        });
        t.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("中断");
        t.interrupt();
    }

    private boolean acquireQueued(){
        boolean failed = true;
        try{
            boolean interrupted = false;
            int i = 0;
            for(;;){
                if(i==100){
                    System.out.println("获取锁成功");
                    failed = false;
                    return interrupted;
                }
                i++;
                if(i==50 && parkAndCheckInterrupt()) {
                    System.out.println("设置标志");
                    interrupted = true;
                }
            }
        } finally {
            if(failed) {
                System.out.println("释放");
            }
        }

    }

    private boolean parkAndCheckInterrupt(){
        System.out.println("线程阻塞");
        LockSupport.park(this);
        System.out.println("线程唤醒");
        return Thread.interrupted();
    }
}
