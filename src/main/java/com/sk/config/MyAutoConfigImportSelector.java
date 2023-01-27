package com.sk.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {
				"com.sk.config.autoconfig.DispatcherServletConfig",
				"com.sk.config.autoconfig.TomcatWebServerConfig"
		};
	}

}
