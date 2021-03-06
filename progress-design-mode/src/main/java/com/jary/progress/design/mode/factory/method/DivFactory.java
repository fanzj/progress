package com.jary.progress.design.mode.factory.method;

import com.jary.progress.design.mode.factory.simple.Operation;
import com.jary.progress.design.mode.factory.simple.OperationDiv;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:50 下午
 */
public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
