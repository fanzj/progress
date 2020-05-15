package com.jary.progress.design.mode.strategy;

/**
 * @author fanzhengjie
 * @date 2020/5/13 10:55 下午
 * 返利收费类
 * 如满300减100
 */
public class CashReturn extends CashSuper{

    //满足条件金额
    private double moneyCondition;
    //反利金额
    private double moneyReturn ;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        return money > moneyCondition ? (money - Math.floor(money / moneyCondition) * moneyReturn) : money;
    }
}
