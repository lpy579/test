package com.example.springboot.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Configure the time zone to be used in Hibernate JPA.
 * 
 * @author bobyuan
 */
@Configuration
public class TimeZoneConfig {
	private static final Logger logger = LoggerFactory.getLogger(TimeZoneConfig.class);
	
	/**
	 * Set UTC as system default time zone, used by Hibernate JPA.
	 * 
	 * Spring Boot: Time Zone configuration using Hibernate
	 * https://aboullaite.me/spring-boot-time-zone-configuration-using-hibernate/
	 */
	@PostConstruct
	void started() {
		TimeZone tzUTC = TimeZone.getTimeZone("UTC");
		TimeZone.setDefault(tzUTC);
		logger.info("Set system default timezone to UTC, used by Hibernate JPA.");
	}
}
