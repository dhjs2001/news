package com.naver.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.naver.reservation.service", "com.naver.reservation.detail","com.naver.reservation.main","com.naver.reservation.reservation", "com.naver.reservation.login" })
@Import({ DBConfig.class })
public class ApplicationConfig {
	
}
