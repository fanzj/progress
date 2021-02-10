package com.jary.progress.design.mode.strategy;

/**
 * @author fanzhengjie
 * @date 2020/5/15 9:40 上午
 */
public enum CashTypeEnum {
    NORMAL("正常收费", "com.jary.progress.design.mode.strategy.CashNormal"),
    RETURN("满300返100", "com.jary.progress.design.mode.strategy.CashReturn"),
    REBATE("打8折", "com.jary.progress.design.mode.strategy.CashRebate");


    private CashTypeEnum(String type, String clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    private String type;
    private String clazz;

    public static CashTypeEnum getBy(String type) {
        for (CashTypeEnum cashTypeEnum : CashTypeEnum.values()) {
            if (cashTypeEnum.getType().equals(type)) {
                return cashTypeEnum;
            }
        }
        return null;
    }


    public String getType() {
        return type;
    }

    public String getClazz() {
        return clazz;
    }
}
