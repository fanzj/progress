package com.jary.progress.design.mode.factory.simple;

/**
 * @author fanzhengjie
 * @date 2020/5/9 6:37 下午
 */
public class OperationSub extends Operation {

    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}
