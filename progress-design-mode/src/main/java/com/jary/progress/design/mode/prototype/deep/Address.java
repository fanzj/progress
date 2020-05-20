package com.jary.progress.design.mode.prototype.deep;

import lombok.Data;

/**
 * @author fanzhengjie
 * @date 2020/5/20 10:13 下午
 */
@Data
public class Address implements Cloneable {

    private String type;

    private String value;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
