package com.jary.progress.design.mode.factory.simple;

/**
 * @author fanzhengjie
 * @date 2020/5/9 4:27 下午
 */
public class OperationAdd extends Operation {

    @Override
    protected double getResult(double numberA, double numberB) {
        return numberA + numberB;
    }
}
