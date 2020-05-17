package com.jary.progress.design.mode.strategy;

/**
 * @author fanzhengjie
 * @date 2020/5/13 10:15 下午
 * 正常收费类
 */
public class CashNormal extends CashSuper {

    /**
     * 原价返回
     * @param money 原价
     * @return
     */
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
