package com.jary.progress.design.mode.decorator;

/**
 * @author fanzhengjie
 * @date 2020/5/15 11:20 下午
 * 装饰类
 */
public abstract class Decorator extends Component {

    protected Component component;//聚合

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
