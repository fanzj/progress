package com.jary.progress.juc.thread.threadLocal;

import java.util.LinkedHashMap;

/**
 * @author fanzhengjie
 * @create 2019/12/1 下午4:35
 * @description 子线程可以使用主线程中的本地变量
 */
public class InheritableThreadLocalTest implements Runnable{

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始...");
        inheritableThreadLocal.set("主线程赋值");
        threadLocal.set("test");

        new Thread(new InheritableThreadLocalTest()).start();

        System.out.println("主线程休眠3秒...");
        Thread.sleep(3000);
        System.out.println("主线程结束");

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.get("as");
        //map.put();
    }


    @Override
    public void run() {
        System.out.println("子线程开始...");
        System.out.println("子线程获取本地变量的值：" + inheritableThreadLocal.get());
        System.out.println("子线程获取本地变量的值2：" + threadLocal.get());
        System.out.println("子线程结束...");
    }
}
