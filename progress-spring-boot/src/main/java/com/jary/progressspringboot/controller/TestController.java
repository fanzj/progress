package com.jary.progressspringboot.controller;

import com.alibaba.fastjson.JSON;
import com.jary.progressspringboot.domain.Student;
import com.jary.progressspringboot.service.HashService;
import com.jary.progressspringboot.utils.ApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fanzhengjie
 * @date 2020/5/28 11:23 上午
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @Resource
    private HashService hashService;

    @Resource
    private ApplicationContext context;

    @Resource
    private ApplicationContextUtils applicationContextUtils;

    /**
     * 测试ApplicationContext获取bean
     * @return
     */
    @RequestMapping("applicationContext")
    public String testApplicationContext(){
        Student s = (Student) context.getBean("student");
        return JSON.toJSONString(s);
    }

    /**
     * 测试ApplicationContext获取bean
     * @return
     */
    @RequestMapping("applicationContextUtils")
    public String testApplicationContextUtils(){
        Student s = (Student) applicationContextUtils.getApplicationContext().getBean("student");
        return JSON.toJSONString(s);
    }

    /**
     * 测试aop拦截注解对字段进行hash
     * @return
     */
    @RequestMapping("hash")
    public String testHashService() {
        Student s = (Student) context.getBean("student");
        System.out.println(s);
        return  hashService.hashTest(s);
    }
}
