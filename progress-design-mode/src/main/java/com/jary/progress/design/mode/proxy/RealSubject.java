package com.jary.progress.design.mode.proxy;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:24 下午
 */
public class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
