package com.androidcommand.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
    public void onStartup(ServletContext container) throws ServletException {
     
		System.out.println("In MyWebApplicationInitializer onStartup");
		System.out.println("Processing MyWebApplicationInitializer-servlet.xml to set the web application context");
		
	/*	
	 * root-context.xml is the Spring Root Application Context Configuration. 
     * It's optional. It's for configuring your non-web beans. 
     * You need it for Spring Security or OpenEntityManagerInView Filter though. 
     * It would be better to place it in meta-inf/spring.
	 */

	/*	XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        rootContext.setConfigLocation("/WEB-INF/config/root-context.xml");
        container.addListener(new ContextLoaderListener(rootContext));          */
		
	/*
	 *   -servlet.xml is the Spring Web Application Context Configuration. 
	 * It's for configuring your Spring beans in a web application. 	
	 */

        XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
        dispatcherContext.setConfigLocation("/WEB-INF/MyWebApplicationInitializer-servlet.xml");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        System.out.println("In MyWebApplicationInitializer dispatcher " + dispatcher.toString());
    }
}