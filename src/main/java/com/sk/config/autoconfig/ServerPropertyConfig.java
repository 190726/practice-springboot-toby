package com.sk.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.sk.config.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertyConfig {
	
	@Bean
	public ServerProperties serverProperties(Environment env) {
		return Binder.get(env).bind("", ServerProperties.class).get();
	}
}
