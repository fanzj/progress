package com.jary.progress.design.mode.strategy;

/**
 * @author fanzhengjie
 * @date 2020/5/13 10:14 下午
 * 策略模式
 * 现金收费抽象类
 */
public abstract class CashSuper {

    /**
     * 收取现金
     * @param money 原价
     * @return 当前价
     */
    public abstract double acceptCash(double money);
}
