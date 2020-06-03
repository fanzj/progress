package com.jary.progress.common.enmus;

/**
 * @author fanzhengjie
 * @date 2020/6/3 10:43 上午
 */
public enum WeekEnum {

    Monday(1, "星期一"),
    Tuesday(2, "星期二"),
    Wednesday(3, "星期三"),
    Thursday(4, "星期四"),
    Friday(5, "星期五"),
    Saturday(6, "星期六"),
    Sunday(7, "星期日");

    private final int code;
    private final String value;

    private WeekEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
