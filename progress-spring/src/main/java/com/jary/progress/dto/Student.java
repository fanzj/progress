package com.jary.progress.dto;

import com.jary.progress.annotation.Hash;
import lombok.Data;
import lombok.ToString;

/**
 * @author fanzhengjie
 * @date 2020/5/26 10:38 上午
 */
@Data
@ToString
public class Student {

    private Long id;

    @Hash
    private String name;

    /**
     * 性别 male/female
     */
    private String sex;

    private Double grade;

    private String classNo;

    private String school;

    private String address;
}
