package com.sk.helloboot;

import org.springframework.stereotype.Service;

@Service
public class SimpleHelloService implements HelloService{

	@Override
	public String sayHello(String name) {
		System.out.println(String.format("input name is %s", name));
		return "Hello " + name;
	}
}