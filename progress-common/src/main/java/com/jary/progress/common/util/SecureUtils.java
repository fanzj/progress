package com.jary.progress.common.util;

import org.apache.commons.lang3.StringUtils;

public class SecureUtils {

    /**
     * 证件号掩码格式：前6后4
     */
    public static String getIdCardMask(String origin) {

        if (StringUtils.isBlank(origin) || origin.length() < 18) {
            return origin;
        }

        int len = origin.length();

        return origin.substring(0, 6) + "****" + origin.substring(len - 4, len);
    }

    /**
     * 手机号号掩码格式：前3后4
     *
     * @param mobile
     * @return
     */
    public static String getMobileMask(String mobile) {
        if (StringUtils.isBlank(mobile) || mobile.length() < 10) {
            return mobile;
        }
        return mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4);
    }

    /**
     * 显示名称掩码格式：例：张三（张*）；王小二（王*二）
     *
     * @param displayName
     * @return
     */
    public static String getDispalyNameMask(String displayName) {
        if (StringUtils.isBlank(displayName) || displayName.length() == 1) {
            return displayName;
        }
        if (displayName.length() == 2) {
            return displayName.substring(0, 1) + "*";
        } else {
            return displayName.substring(0, 1) + "*" + displayName.substring(displayName.length() - 1);
        }

    }

    /**
     * 银行卡号掩码格式：前4后4
     */
    public static String getBankAccout(String origin) {

        if (StringUtils.isBlank(origin)) {
            return origin;
        }

        int len = origin.length();

        return origin.substring(0, 4) + "****" + origin.substring(len - 4, len);
    }
}
