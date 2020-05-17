package com.jary.progress.design.mode.strategy;

import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/13 11:02 下午
 */
public class StrategyTest {

    /**
     * 单纯策略模式测试
     */
    @Test
    public void testStrategy() {
        CashContext cs = null;
        //收费类型
        String type = "满300返100";
        switch (type) {
            case "正常收费":
                cs = new CashContext(new CashNormal());
                break;
            case "满300返100":
                cs = new CashContext(new CashReturn(300.0, 100.0));
                break;
            case "打8折":
                cs = new CashContext(new CashRebate(0.8));
                break;
        }

        System.out.println(cs.getResult(100 * 5));


    }

    /**
     * 策略与简单工厂结合，降低耦合
     */
    @Test
    public void testStrategySimpleFactory(){
        CashContextV2 context = new CashContextV2("打8折");
        System.out.println(context.getResult(100*5));
    }

    /**
     * 策略模式结合反射
     */
    @Test
    public void testStrategyReflect() {
        CashContextV3 context = new CashContextV3("打8折", new Class[]{double.class}, new Object[]{0.8});
        System.out.println(context.getResult(500));
    }

}
