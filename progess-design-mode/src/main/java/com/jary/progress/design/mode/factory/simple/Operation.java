package com.jary.progress.design.mode.factory.simple;

/**
 * @author fanzhengjie
 * @date 2020/5/8 9:53 下午
 * 1.简单工厂模式
 */
public abstract class Operation {

    private double numberA;

    private double numberB;

    protected abstract double getResult(double numberA, double numberB);
}
