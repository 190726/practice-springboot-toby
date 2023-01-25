package com.sk.helloboot;

public class SimpleHelloService implements HelloService{

	@Override
	public String sayHello(String name) {
		System.out.println(String.format("input name is %s", name));
		return "Hello " + name;
	}
}