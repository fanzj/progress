package com.jary.progress.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author fanzhengjie
 * @date 2020/5/26 1:37 下午
 */
@Data
@ToString
public class Person implements InitializingBean, DisposableBean {

    private String name;

    public void sayWord(String word) {
        System.out.println(name + " say: " + word);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("person InitializingBean#afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("person DisposableBean#destroy");
    }

    public void startInit() {
        System.out.println("xml config init-method=startInit");
    }

    public void endDestroy() {
        System.out.println("xml config destroy-method=endDestroy");
    }
}
