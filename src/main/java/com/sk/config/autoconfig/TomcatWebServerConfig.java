package com.sk.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class TomcatWebServerConfig {
	
	//ApplicationContextAware를 구현하면, applicationContext를 자동주입해준다.
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
}