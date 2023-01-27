package com.sk.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ConditionalTest {
	
	@Test
	void conditional() {
		//Test용 ApplicationContext
		ApplicationContextRunner contextRunner = new ApplicationContextRunner();
		contextRunner.withUserConfiguration(Config1.class)
		.run(context -> {
			Assertions.assertThat(context).hasSingleBean(MyBean.class);
		});
		
		ApplicationContextRunner contextRunner2 = new ApplicationContextRunner();
		contextRunner2.withUserConfiguration(Config2.class)
		.run(context -> {
			Assertions.assertThat(context).doesNotHaveBean(MyBean.class);
		});

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	@Conditional(BooleanContition.class)
	@interface BooleanConditinal{
		boolean value();
	}
	
	@Configuration
	@BooleanConditinal(true)
	static class Config1{
		
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
	}
	
	@Configuration
	@BooleanConditinal(false)
	static class Config2{
		
		@Bean
		MyBean myBean() {
			return new MyBean();
		}
	}

	
	static class MyBean{}
	
	static class BooleanContition implements Condition{

		@Override
		public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
			//
			Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(BooleanConditinal.class.getName());
			Boolean value = (Boolean) annotationAttributes.get("value");
			return value;
		}
	}
}