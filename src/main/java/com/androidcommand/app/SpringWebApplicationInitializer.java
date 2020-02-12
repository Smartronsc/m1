/*
 * =============================================================================
 *
 *   Copyright (c) 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.androidcommand.app.web.SpringWebConfig;


public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String CHARACTER_ENCODING = "UTF-8";


    public SpringWebApplicationInitializer() {
        super();
    }



    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("in SpringWebApplicationInitializer");
        return new Class<?>[] { SpringWebConfig.class };
    }

 /*   @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("in SpringWebApplicationInitializer");
        return new Class<?>[] { SpringBusinessConfig.class };
    } */

    @Override
    protected String[] getServletMappings() {
        System.out.println("in SpringWebApplicationInitializer");
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);
        System.out.println("in SpringWebApplicationInitializer");
        return new Filter[] { encodingFilter };
    }



	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}
