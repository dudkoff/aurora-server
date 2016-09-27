package com.aurora.notes.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configurable
@ComponentScan("com.aurora.notes.resources")
class WebConfig extends WebMvcConfigurerAdapter {
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    @Override
    public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}