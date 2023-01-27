package com.sk.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService{

	private final HelloService helloService;
	
	//HelloDecorator가 Primary 이므로, HelloContorller 와 의존관계를 맺으며, 
	//남는 1개의 SimpleHelloService가 HelloDecore와 의존관계를 맺게 된다.
	public HelloDecorator(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@Override
	public String sayHello(String name) {
		return "*" + helloService.sayHello(name) + "*";
	}
}