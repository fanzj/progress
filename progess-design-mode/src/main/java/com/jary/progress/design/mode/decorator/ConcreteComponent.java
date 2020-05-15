package com.jary.progress.design.mode.decorator;

/**
 * @author fanzhengjie
 * @date 2020/5/15 11:19 下午
 */
public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
