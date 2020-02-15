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
     
		System.out.println("In onStartup");
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
        System.out.println(dispatcher.toString());
    }
	
	
	
	
	
	/*
    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.register(Companies.class);
        ctx.refresh();
        System.out.println("In MyWebApplicationInitializer ");

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("CompaniesServlet", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    } */
}