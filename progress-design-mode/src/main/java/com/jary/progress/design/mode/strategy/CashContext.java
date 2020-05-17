package com.jary.progress.design.mode.strategy;

/**
 * @author fanzhengjie
 * @date 2020/5/13 11:00 下午
 * 策略模式
 */
public class CashContext {

    private CashSuper cs;

    public CashContext(CashSuper cs) {
        this.cs = cs;
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
