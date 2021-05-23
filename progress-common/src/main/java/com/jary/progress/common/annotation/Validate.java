package com.jary.progress.common.annotation;

import java.lang.annotation.*;

/**
 * @author fanzhengjie
 * @create 2019/1/12 上午11:08
 * @description 自定义注解:通过注解进行校验
 */
@Documented
@Inherited
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    int min() default 1;

    int max() default 10;

    boolean isNotNull() default true;

}
