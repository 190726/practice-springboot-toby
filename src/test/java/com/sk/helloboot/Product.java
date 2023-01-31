package com.sk.helloboot;

public class Product {

	private String name;
	private long price;
	private DiscountPolicy policy;

	public Product(String name, long price, DiscountPolicy policy) {
		this.name = name;
		this.price = price;
		this.policy = policy;
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public DiscountPolicy getPolicy() {
		return policy;
	}
}
