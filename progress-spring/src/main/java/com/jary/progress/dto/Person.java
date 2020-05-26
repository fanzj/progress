package com.jary.progress.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author fanzhengjie
 * @date 2020/5/26 1:37 下午
 */
@Data
@ToString
public class Person {

    private String name;

    public void sayWord(String word){
        System.out.println(name + " say: "+word);
    }

}
