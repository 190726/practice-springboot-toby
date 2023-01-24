package com.sk.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		System.out.println("--start--");
		SpringApplication.run(HellobootApplication.class, args);
	}

}
