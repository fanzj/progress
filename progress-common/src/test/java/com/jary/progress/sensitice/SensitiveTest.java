package com.jary.progress.sensitice;

import com.jary.progress.common.bean.UserDO;
import com.jary.progress.common.util.SensitiveUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/5/11 9:56 上午
 */
public class SensitiveTest {

    private UserDO userDO;

    @Before
    public void setUp(){
        userDO = new UserDO();
        userDO.setId(1);
        userDO.setName("王三无");
        userDO.setAddress("浙江杭州");
        userDO.setSex((byte) 0);
    }

    @Test
    public void testSensitive() throws Exception {
        System.out.println(SensitiveUtils.convert(userDO));
    }
}
