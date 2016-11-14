package com.akash.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by akash on 08/11/16.
 */

@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
    public static void main(String args[]){
        SpringApplication.run(AppConfig.class,args);
    }
}
