package com.jary.progress.config;

import com.jary.progress.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fanzhengjie
 * @date 2020/5/26 1:58 下午
 * 单元测试方法二：整合junit和spring-test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-beans.xml"})
public class BeanConfigTest2 {

    @Autowired
    private Person person;

    @Test
    public void test() {
        person.sayWord("hello");
    }
}
