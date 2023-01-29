package com.sk.config;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

public class MyOnClassCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass.class.getName());
		String value = (String) attrs.get("value");
		boolean isPresent = ClassUtils.isPresent(value, context.getClassLoader());
		System.out.println(value + ":" + isPresent);
		return ClassUtils.isPresent(value, context.getClassLoader());
	}
}