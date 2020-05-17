package com.jary.progress.design.mode.factory.simple;

/**
 * @author fanzhengjie
 * @date 2020/5/9 6:38 下午
 */
public class OperationDiv extends Operation{

    @Override
    protected double getResult(double numberA, double numberB) {
        if(Double.compare(numberB, 0d) == 0){
            throw new RuntimeException("除数不能为0");
        }
        return numberA / numberB;
    }
}
