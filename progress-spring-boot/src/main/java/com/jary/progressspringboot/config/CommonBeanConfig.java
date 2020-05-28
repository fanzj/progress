package com.jary.progressspringboot.config;

import com.jary.progressspringboot.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanzhengjie
 * @date 2020/5/28 11:25 上午
 */
@Configuration
public class CommonBeanConfig {

    @Bean
    public Student student(){
        Student s = new Student();
        s.setId(1L);
        s.setName("周三天");
        s.setAddress("浙江省杭州市西湖区");
        s.setClassNo("No.1");
        s.setGrade(95.0);
        s.setSchool("东方中学");
        s.setSex("male");
        return s;
    }
}
