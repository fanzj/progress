package com.jary.progress.design.mode.factory.method;

import com.jary.progress.design.mode.factory.simple.Operation;
import com.jary.progress.design.mode.factory.simple.OperationSub;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:49 下午
 */
public class SubFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
