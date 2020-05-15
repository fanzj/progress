package com.jary.progress.design.mode.decorator;

/**
 * @author fanzhengjie
 * @date 2020/5/15 11:21 下午
 */
public class ConcreteDecoratorA extends Decorator {

    private String addedState;

    @Override
    public void operation() {
        super.operation();
        this.addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }
}
