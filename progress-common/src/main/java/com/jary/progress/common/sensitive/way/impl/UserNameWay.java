package com.jary.progress.common.sensitive.way.impl;

import com.jary.progress.common.sensitive.way.Way;
import org.apache.commons.lang3.StringUtils;

/**
 * @author fanzhengjie
 * @date 2020/5/9 2:51 下午
 */
public class UserNameWay implements Way<String> {

    public String transform(String var1) {
        if (StringUtils.isBlank(var1)) {
            return "";
        } else {
            String name = StringUtils.left(var1, 1);
            return StringUtils.rightPad(name, StringUtils.length(var1), "*");
        }
    }

    public static void main(String[] args) {
        String s = "周九年";
        Way way = new UserNameWay();
        String res = (String) way.transform(s);
        System.out.println(res);
    }
}
