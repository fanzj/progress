package com.jary.progress.service.impl;

import com.jary.progress.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author fanzhengjie
 * @date 2020/5/26 3:56 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-aop.xml" })
public class UserServiceImplTest {

    @Autowired
    private UserService us;

    @Test
    public void fun1(){
        us.save();
    }
}
