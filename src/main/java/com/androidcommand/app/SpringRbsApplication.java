package com.androidcommand.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringRbsApplication {
	
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/m1");
		SpringApplication.run(SpringRbsApplication.class, args);
		
		System.out.println("SpringRbsApplication is now running");
    } 
}


