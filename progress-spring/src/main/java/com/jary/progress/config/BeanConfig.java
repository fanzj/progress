package com.jary.progress.config;

import com.jary.progress.dto.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanzhengjie
 * @date 2020/5/26 10:53 上午
 */
@Configuration
public class BeanConfig {

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("human");
        return person;
    }
}
