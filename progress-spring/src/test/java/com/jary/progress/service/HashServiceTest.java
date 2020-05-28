package com.jary.progress.service;

import com.jary.progress.dto.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fanzhengjie
 * @date 2020/5/26 3:44 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-common-beans.xml" })
public class HashServiceTest {

    @Autowired
    private HashService hashService;

    @Test
    public void testHash(){
        Student student = new Student();
        student.setName("LiLei");
        student.setId(1L);
        student.setGrade(80.0);
        hashService.hashTest(student);
    }
}
