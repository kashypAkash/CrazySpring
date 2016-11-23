package com.akash.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by akash on 08/11/16.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(applicationClass);
    }

    public static void main(String args[]){
        SpringApplication.run(applicationClass,args);
    }

    private static Class<AppConfig> applicationClass = AppConfig.class;
}
