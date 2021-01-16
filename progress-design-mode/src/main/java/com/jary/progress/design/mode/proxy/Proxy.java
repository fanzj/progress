package com.jary.progress.design.mode.proxy;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:25 下午
 */
public class Proxy extends Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("代理前");
        subject.request();
        System.out.println("代理后");
    }
}
