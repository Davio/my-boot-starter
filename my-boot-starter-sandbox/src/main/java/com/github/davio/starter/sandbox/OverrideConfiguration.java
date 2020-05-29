package com.github.davio.starter.sandbox;

import com.github.davio.starter.OtherService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OverrideConfiguration {

    @Bean
    public OtherService otherService() {
        return new OverrideService();
    }

    public static class OverrideService implements OtherService {

        @Override
        public String getTheAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything() {
            return "love";
        }
    }
}
