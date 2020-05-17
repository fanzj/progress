package com.jary.progress.design.mode.factory.simple;

import java.text.MessageFormat;

/**
 * @author fanzhengjie
 * @date 2020/5/9 6:40 下午
 */
public class OperationFactory {

    public static Operation createOperation(String operate) {

        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                throw new RuntimeException(MessageFormat.format("暂不支持的操作, operation:{0}", operate));

        }

        return operation;
    }
}
