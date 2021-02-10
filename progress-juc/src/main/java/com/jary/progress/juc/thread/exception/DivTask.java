package com.jary.progress.juc.thread.exception;

/**
 * @author fanzhengjie
 * @create 2018/11/16 上午11:15
 * @description 工作线程，执行除法操作
 */
public class DivTask implements Runnable{

    private int number, division;

    public DivTask(int number, int division) {
        this.number = number;
        this.division = division;
    }

    @Override
    public void run() {
        System.out.println(number/division);
    }
}
