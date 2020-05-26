package com.github.davio.starter.config;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ApplicationAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder mapperBuilder) {
        return mapperBuilder.build();
    }

    @ConditionalOnMissingBean
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @ConditionalOnMissingBean
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        return new Jackson2ObjectMapperBuilder()
                .serializationInclusion(NON_EMPTY)
                .modules(new JavaTimeModule(), new JaxbAnnotationModule(), new JsonNullableModule())
                .featuresToDisable(WRITE_DATES_AS_TIMESTAMPS);
    }
}
