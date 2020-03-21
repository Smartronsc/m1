package com.androidcommand.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.androidcommand.app.controller.CompaniesController;

@SpringBootApplication
@RestController
public class SpringRbsApplication {	
	/*
	 * main just a standard method that follows the Java convention for an application entry point. Our main method delegates to Spring Boot’s
     * SpringApplication class by calling run. SpringApplication bootstraps our application SpringRbsApplication, starting Spring, which, in turn, 
     * starts the auto-configured Tomcat web server. We need to pass SpringRbsApplication.class as an argument to the run method to name 
     * SpringApplication as the primary Spring component. The args array is also passed through to expose any command-line arguments.
	 */
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/m1");
		SpringApplication.run(SpringRbsApplication.class, args);
		
		System.out.println("SpringRbsApplication is now running");
		
	    @SuppressWarnings("resource")
		BeanFactory beanfactory = new ClassPathXmlApplicationContext("applicationContext.xml");
	    CompaniesController companiesController = (CompaniesController) beanfactory.getBean("CompaniesController");
	        System.out.println("SpringRbsApplication bean " + companiesController);
    } 
}
