package com.jary.progress.config;

import com.jary.progress.dto.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fanzhengjie
 * @date 2020/5/26 1:39 下午
 * 单元测试方法一：手动加载spring的配置文件，并启动spring容器
 */
public class BeanConfigTest {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanConfig.class);
        ctx.refresh();
    }

    /**
     * 基于注解
     */
    @Test
    public void testPerson(){
        Person person = (Person) ctx.getBean("person");
        person.sayWord("hello");
        System.out.println(person);
    }

    /**
     * 基于xml配置
     */
    @Test
    public void testPerson2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        context.start();

        Person person = (Person) context.getBean("person2");
        person.sayWord("hello");
        System.out.println(person);

    }
}
