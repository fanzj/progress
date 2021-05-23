package com.jary.progress.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chujiale
 * @version 2018年1月10日
 */
public class SensitiveInfoUtils {


    public static final String ID_CARD = "ID_CARD";
    public static final String ACC_NAME = "ACC_NAME";
    public static final String BANK_CARD = "BANK_CARD";
    public static final String PHONE_NUM = "PHONE_NUM";

    public static String tuomin(String sensitiveType, String oriMsg) {
        if (StringUtils.isBlank(oriMsg)) {
            return oriMsg;
        }
        switch (sensitiveType) {
            case ID_CARD:
                return SensitiveInfoUtils.idCard(oriMsg);
            case ACC_NAME:
                return SensitiveInfoUtils.chineseName(oriMsg);
            case BANK_CARD:
                return SensitiveInfoUtils.bankCard(oriMsg);
            case PHONE_NUM:
                return SensitiveInfoUtils.phoneNum(oriMsg);
            default:
                return oriMsg;
        }
    }

    /**
     * [姓名] 隐藏一位姓<例子：*杰伦>
     */
    private static String chineseName(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.substring(fullName, 1),
                StringUtils.length(fullName), "*");
    }

    /**
     * [身份证号] 显示前三位，后四位，其他隐藏。共计18位或者15位。<例子：*************5762>
     */
    private static String idCard(String str) {
        return strProcess(str, 3, 4);
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
     */
    private static String phoneNum(String str) {
        return strProcess(str, 3, 4);
    }

    /**
     * [银行卡号] 前四位，后四位，其他用星号隐藏每位1个星号<例子:6222************1234>
     */
    private static String bankCard(String str) {
        return strProcess(str, 4, 4);
    }

    /**
     * 字符串脱敏处理
     * str.length<=left+right返回原字符串
     *
     * @param str   原字符串
     * @param left  取左边的字符串长度
     * @param right 取右边的字符串长度
     * @return 脱敏后的字符串
     */
    private static String strProcess(String str, int left, int right) {
        if (StringUtils.isBlank(str) || str.length() <= (left + right)) {
            return str;
        }
        return StringUtils.left(str, left).concat(
                StringUtils.leftPad(StringUtils.right(str, right), str.length(), "*")
                        .substring(left, str.length()));
    }
}
