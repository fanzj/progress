package com.jary.progress.common.annonation;

import com.jary.progress.common.annonation.demo1.UserFactory;
import com.jary.progress.common.annonation.demo2.UserCheck;
import com.jary.progress.common.bean.User;
import org.junit.Test;

/**
 * @author fanzhengjie
 * @date 2020/6/3 11:37 上午
 */
public class AnnonationTest {

    @Test
    public void testInit(){
        User user = UserFactory.create();
        System.out.println(user);
    }

    @Test
    public void testValidate(){
        User user = new User();

        user.setName("liang");
        user.setAge("12");

        System.out.println(UserCheck.check(user));
    }
}
