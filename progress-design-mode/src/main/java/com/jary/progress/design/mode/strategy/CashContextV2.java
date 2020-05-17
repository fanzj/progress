package com.jary.progress.design.mode.strategy;

/**
 * @author fanzhengjie
 * @date 2020/5/13 11:09 下午
 * 策略模式和简单工厂结合
 */
public class CashContextV2 {

    private CashSuper cs = null;

    public CashContextV2(String type) {
        switch (type) {
            case "正常收费":
                CashNormal cashNormal = new CashNormal();
                cs = cashNormal;
                break;
            case "满300返100":
                CashReturn cashReturn = new CashReturn(300.0, 50.0);
                cs = cashReturn;
                break;
            case "打8折":
                CashRebate cashRebate = new CashRebate(0.8);
                cs = cashRebate;
                break;
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
