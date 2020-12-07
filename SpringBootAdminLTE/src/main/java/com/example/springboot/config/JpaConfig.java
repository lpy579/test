package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Simply specify the JPA repository lookup packages.
 * 
 * @author bobyuan
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.example.springboot.repository.jpa")
public class JpaConfig {

}
