package com.androidcommand.app;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
    	System.out.println("In AppConfig.java for MyBean ");
		return null;
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:WEB-INF");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        System.out.println("In AppConfig.java for messages " + messageSource.getBasenameSet());
        return messageSource;
    } 
}