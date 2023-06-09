package com.assignment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(
        scanBasePackages = {
                "com.assignment.application",
                "com.assignment.gateway",
                "com.assignment.common",
                "com.assignment.db",
        },
        exclude = {SecurityAutoConfiguration.class}
)
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = {"com.assignment.application"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}