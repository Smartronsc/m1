package com.androidcommand.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
    	System.out.println("In AppConfig for MyBeant ");
		return null;
    }
}