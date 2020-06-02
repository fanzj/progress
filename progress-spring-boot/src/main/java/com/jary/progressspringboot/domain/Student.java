package com.jary.progressspringboot.domain;

import com.jary.progressspringboot.annotation.Hash;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    private String nameHash;

    /**
     * 性别 male/female
     */
    private String sex;

    private Double grade;

    private String classNo;

    @NotBlank(message = "学校信息不能为空")
    private String school;

    @NotNull(message = "地址不能为空")
    private String address;
}
