package com.github.davio.starter.sandbox;

import com.github.davio.starter.config.EnableMyConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMyConfig
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
