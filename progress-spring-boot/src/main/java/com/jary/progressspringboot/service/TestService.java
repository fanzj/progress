package com.jary.progressspringboot.service;

import com.alibaba.fastjson.JSON;
import com.jary.progressspringboot.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    public String testNotNull(Student student) {
        log.info("TestService req:{}", JSON.toJSONString(student));
        return "调用成功";
    }
}
