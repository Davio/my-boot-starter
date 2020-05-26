package com.github.davio.starter.interfaces.messaging;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "amqp")
@Data
public class AmqpProperties {

    private String addresses = "localhost:5672";
}
