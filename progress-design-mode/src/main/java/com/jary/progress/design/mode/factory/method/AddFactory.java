package com.jary.progress.design.mode.factory.method;

import com.jary.progress.design.mode.factory.simple.Operation;
import com.jary.progress.design.mode.factory.simple.OperationAdd;

/**
 * @author fanzhengjie
 * @date 2020/5/20 9:48 下午
 * 加法工厂
 */
public class AddFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
