package com.jary.progressspringboot.service;

import com.jary.progressspringboot.annotation.DomainFieldHash;
import com.jary.progressspringboot.domain.Student;
import org.springframework.stereotype.Service;

/**
 * @author fanzhengjie
 * @date 2020/5/26 10:42 上午
 */
@Service
public class HashService {

    @DomainFieldHash
    public String hashTest(Student student) {
        System.out.println("--- start hashTest ---");
        System.out.println(student);
        System.out.println("--- end hashTest ---");
        return "ok";
    }
}
