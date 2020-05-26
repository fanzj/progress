package com.jary.progress.annotation;

import java.lang.annotation.*;

/**
 * @author fanzhengjie
 * @date 2020/5/26 10:17 上午
 * 对字段进行hash
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Hash {
}
