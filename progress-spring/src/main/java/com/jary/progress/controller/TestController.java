package com.jary.progress.controller;

import com.alibaba.fastjson.JSON;
import com.jary.progress.dto.Student;
import com.jary.progress.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fanzhengjie
 * @date 2020/5/28 11:00 上午
 */
@RestController
public class TestController {

    @Resource
    private HashService hashService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testHashService(){
        Student student = new Student();
        student.setId(1L);
        student.setName("章大大");
        student.setGrade(90.0);
        return hashService.hashTest(student);
    }
}
