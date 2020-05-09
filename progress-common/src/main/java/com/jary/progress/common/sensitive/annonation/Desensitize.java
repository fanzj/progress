package com.jary.progress.common.sensitive.annonation;

import com.jary.progress.common.sensitive.way.Way;

import java.lang.annotation.*;

/**
 * @author fanzhengjie
 * @date 2020/5/9 2:58 下午
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitize {

    Class<? extends Way> way();
}
