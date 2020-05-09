package com.jary.progress.common.sensitive;

import com.jary.progress.common.bean.UserDO;
import com.jary.progress.common.util.SensitiveUtils;

/**
 * @author fanzhengjie
 * @date 2020/5/9 3:43 下午
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setName("王三无");
        userDO.setAddress("浙江杭州");
        userDO.setSex((byte) 0);

        System.out.println(SensitiveUtils.convert(userDO));

    }
}
