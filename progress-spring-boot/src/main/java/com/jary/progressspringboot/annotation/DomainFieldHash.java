package com.jary.progressspringboot.annotation;

import java.lang.annotation.*;

/**
 * @author fanzhengjie
 * @date 2020/5/26 10:19 上午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DomainFieldHash {
}
