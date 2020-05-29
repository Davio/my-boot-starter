package com.github.davio.starter.config;

import com.github.davio.starter.OtherService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public OtherService otherService() {
        return new OtherService() {};
    }
}
