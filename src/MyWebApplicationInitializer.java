package com.androidcommand.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
    public void onStartup(ServletContext container) throws ServletException {
     
		/*
		 *  Load Spring web applicationConfiguration container root context RantConfig.class
		 *  Container objects are called Spring-managed beans (or simply beans), 
		 *  and the container is called an application context (via class ApplicationContext) in the Spring world
		 */
        AnnotationConfigWebApplicationContext applicationConfiguration = new AnnotationConfigWebApplicationContext();
        applicationConfiguration.register(RantConfig.class);
        applicationConfiguration.refresh();
        
        /*
         * Manage the lifecycle of the root application context
         */
        container.addListener(new ContextLoaderListener(applicationConfiguration));
        
        /*
         *  Create and register the DispatcherServlet
         *  Inherited from javax.servlet.http.HttpServlet, it is typically configured in the web.xml file.
         *  web.xml is the bean configuration file of WebApplicationContext
         */
        DispatcherServlet servlet = new DispatcherServlet(applicationConfiguration);
        ServletRegistration.Dynamic registration = container.addServlet("rant", servlet);
  //      ServletRegistration.Dynamic registration = container.addServlet("app", servlet);
        registration.setLoadOnStartup(1);	
  //      registration.addMapping("/app/*");
        registration.addMapping("/");
        
//		System.out.println("In MyWebApplicationInitializer onStartup");
//		System.out.println("Processing MyWebApplicationInitializer-servlet.xml to set the web application context");
		
		
        /*
        XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
        dispatcherContext.setConfigLocation("/WEB-INF/MyWebApplicationInitializer-servlet.xml");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        System.out.println("In MyWebApplicationInitializer dispatcher " + dispatcher.toString());
        */
    }
}