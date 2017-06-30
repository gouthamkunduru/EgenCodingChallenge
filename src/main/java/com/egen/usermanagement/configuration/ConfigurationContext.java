package com.egen.usermanagement.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Implemented During Egen coding Challenge 
 * Created by Goutham Kunduru on 06/27/2017.
 * 
 * @author Goutham Kunduru
 * @version 1.0
 */
@Configuration
@ImportResource("/WEB-INF/applicationContext.xml")
public class ConfigurationContext extends WebMvcConfigurerAdapter {
}