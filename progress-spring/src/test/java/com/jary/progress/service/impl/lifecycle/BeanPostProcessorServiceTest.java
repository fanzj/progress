package com.jary.progress.service.impl.lifecycle;

import com.jary.progress.config.BeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fanzhengjie
 * @date 2020/5/26 8:50 下午
 *
 */
public class BeanPostProcessorServiceTest {

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
    public void testBeanPostProcessor(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        context.start();
    }

}
