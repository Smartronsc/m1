package com.androidcommand.app;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


@Configuration
public class RantConfig {

    @Bean
    public Companies myBean() {
    	System.out.println("In RantConfig.java for Companies MyBean ");
		return null;
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:WEB-INF");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        System.out.println("In RantConfig.java for messages " + messageSource.getBasenameSet());
        return messageSource;
    } 
}