package com.sk.config.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import com.sk.config.ConditionalMyOnClass;
import com.sk.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
	
	@Bean("tomcatWebServerConfig")
	@ConditionalOnMissingBean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
}