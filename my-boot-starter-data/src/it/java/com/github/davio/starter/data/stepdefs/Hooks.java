package com.github.davio.starter.data.stepdefs;

import com.github.davio.starter.data.TestApplication;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TestApplication.class)
@ActiveProfiles("test")
@ContextConfiguration
@CucumberContextConfiguration
public class Hooks {
}
