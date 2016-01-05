package com.template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Dispatching servlet configuration
 */
@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
public class WebAppServletConfig extends WebMvcConfigurerAdapter {

    @Autowired
    Environment environment;

    // TODO: all basic configuration here...
}
