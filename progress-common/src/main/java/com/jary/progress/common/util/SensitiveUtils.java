package com.jary.progress.common.util;

import com.alibaba.fastjson.JSON;
import com.jary.progress.common.sensitive.annonation.Desensitize;
import com.jary.progress.common.sensitive.way.Way;

import java.lang.reflect.Field;

/**
 * @author fanzhengjie
 * @date 2020/5/9 3:31 下午
 */
public class SensitiveUtils {

    public static <T> T convert(T bean) throws Exception {
        if (null == bean) {
            return null;
        }

        T result = (T) JSON.parseObject(JSON.toJSONString(bean), bean.getClass());
        for (Class tmp = bean.getClass(); tmp != null; tmp = tmp.getSuperclass()) {
            Field[] fields = tmp.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Desensitize desensitize = field.getAnnotation(Desensitize.class);
                if (null != desensitize) {
                    field.setAccessible(true);
                    Object obj = field.get(bean);
                    Way way = desensitize.way().newInstance();
                    field.set(result, way.transform(obj));
                }
            }

        }
        return result;
    }
}
