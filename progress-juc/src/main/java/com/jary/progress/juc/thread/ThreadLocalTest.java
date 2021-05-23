package com.jary.progress.juc.thread;

/**
 * @author fanzhengjie
 * @create 2019/2/13 下午2:05
 * @description
 */
public class ThreadLocalTest implements Runnable{

    private static ThreadLocal<Integer> num;
    private static ThreadLocal<String> str;

    static {
        num = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return 10;
            }
        };
        str = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "hello world";
            }
        };
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadLocalTest());
        Thread t2 = new Thread(new ThreadLocalTest());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" start, the value is: " + num.get()+", str = "+str.get());
        int localNum = num.get();
        localNum ++;
        num.set(localNum);
        str.set("test");
        str.remove();
        System.out.println(Thread.currentThread().getName()+" end, the value is: " + num.get()+", str = "+str.get());
    }
}
