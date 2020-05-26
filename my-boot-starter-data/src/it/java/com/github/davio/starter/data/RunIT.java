package com.github.davio.starter.data;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.github.davio.starter.data.stepdefs",
        features = "src/it/resources/features",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber/html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/junit.xml"
        },
        strict = true)
public class RunIT {
}
