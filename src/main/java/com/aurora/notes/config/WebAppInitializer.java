package com.aurora.notes.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;


public class WebAppInitializer implements WebApplicationInitializer
{

    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.addMapping("/");
    }

    private void initRootContext(ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        //rootContext.register(MyAppRootContext.class);
        container.addListener(new ContextLoaderListener(rootContext));
    }
}