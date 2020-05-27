package com.jary.progress.service;

import com.jary.progress.dto.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author fanzhengjie
 * @date 2020/5/26 5:30 下午
 */
@Service
public class BeanPostProcessorService implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person) {
            System.out.println("person....postProcessBeforeInitialization");
        }
        System.out.println("postProcessBeforeInitialization... beanName="+beanName+", bean="+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person) {
            System.out.println("person....postProcessAfterInitialization");
        }
        System.out.println("postProcessAfterInitialization... beanName="+beanName+", bean="+bean);
        return bean;
    }
}
