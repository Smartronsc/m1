/*
 * =============================================================================
 *
 *   Copyright (c) 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringBusinessConfig {

    public SpringBusinessConfig() {
        super();
    }

    // Nothing else to be configured here: component scanning will do everything needed

}
