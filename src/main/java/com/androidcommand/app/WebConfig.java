package com.androidcommand.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.androidcommand.app"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/rant.jsp");
    }
    
    @Bean
    public InternalResourceViewResolver resolver() {
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setViewClass(JstlView.class);
       resolver.setPrefix("/WEB-INF/");
       resolver.setSuffix(".jsp");
       return resolver;
    }
}