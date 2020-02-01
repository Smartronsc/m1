package com.androidcommand.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        System.out.println("In MyWebApplicationInitializer ");

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("CompaniesServlet", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}