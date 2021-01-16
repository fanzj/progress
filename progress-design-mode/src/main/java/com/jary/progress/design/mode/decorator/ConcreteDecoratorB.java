package com.jary.progress.design.mode.decorator;

/**
 * @author fanzhengjie
 * @date 2020/5/15 11:22 下午
 */
public class ConcreteDecoratorB extends Decorator {

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    private void addedBehavior() {

    }
}
