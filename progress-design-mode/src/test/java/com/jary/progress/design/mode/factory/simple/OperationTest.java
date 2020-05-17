package com.jary.progress.design.mode.factory.simple;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/9 7:05 下午
 */
public class OperationTest {

    @Test
    public void testOperationAdd(){
        Operation operation = OperationFactory.createOperation("+");
        System.out.println(operation.getResult(4,5));
    }

    @Test
    public void testOperationSub(){
        Operation operation = OperationFactory.createOperation("-");
        System.out.println(operation.getResult(4,5));
    }

    @Test
    public void testOperationMul(){
        Operation operation = OperationFactory.createOperation("*");
        System.out.println(operation.getResult(4,5));
    }

    @Test
    public void testOperationDiv(){
        Operation operation = OperationFactory.createOperation("/");
        System.out.println(operation.getResult(4,5));
    }

    @Test
    public void testOperationDivError(){
        Operation operation = OperationFactory.createOperation("/");
        System.out.println(operation.getResult(4,0));
    }

    @Test
    public void testOperationOther(){
        Operation operation = OperationFactory.createOperation("^");
        System.out.println(operation.getResult(4,5));
    }
}
