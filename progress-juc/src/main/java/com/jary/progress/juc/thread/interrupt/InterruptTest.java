package com.jary.progress.juc.thread.interrupt;

import static java.lang.Thread.interrupted;

/**
 * @author fanzhengjie
 * @create 2019/10/23 下午10:22
 * @description
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                if (interrupted()) {
                    System.out.println("已经是停止状态了!我要退出了!");
                    break;
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("看到这句话说明线程并未终止------");
        });
        thread.start();
        thread.sleep(2000);
        thread.interrupt();
        System.out.println("main catch");
    }

}
