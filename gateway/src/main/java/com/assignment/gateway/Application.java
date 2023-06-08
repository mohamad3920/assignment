package com.assignment.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(
        scanBasePackages = {
                "com.assignment.gateway",
                "com.assignment.common",
        }
)
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = {"com.assignment.gateway"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}