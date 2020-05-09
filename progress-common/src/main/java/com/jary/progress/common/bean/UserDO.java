package com.jary.progress.common.bean;

import com.jary.progress.common.sensitive.annonation.Desensitize;
import com.jary.progress.common.sensitive.way.impl.UserNameWay;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author fanzhengjie
 * @date 2020/5/9 3:03 下午
 */
@Data
@ToString
public class UserDO implements Serializable {

    private Integer id;

    @Desensitize(way = UserNameWay.class)
    private String name;

    private String address;

    private Byte sex;


}
