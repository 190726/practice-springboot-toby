package com.sk.helloboot;

import org.springframework.boot.SpringApplication;

import com.sk.config.MySpringBootApplication;

@MySpringBootApplication
public class App {
	
    public static void main( String[] args ){
    	SpringApplication.run(App.class, args);
    }
}