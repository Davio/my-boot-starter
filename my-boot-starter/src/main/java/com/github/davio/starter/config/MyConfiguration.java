package com.github.davio.starter.config;

import com.github.davio.starter.MyService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
