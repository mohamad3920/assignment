package com.assignment.db.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = {"com.assignment.db.entity", "com.assignment.db.repository"})
@ComponentScan(basePackages = {"com.assignment.db.repository"})
@EntityScan(basePackages = {"com.assignment.db.entity"})
@EnableTransactionManagement
@Configuration
public class RepositoryConfigure {
}