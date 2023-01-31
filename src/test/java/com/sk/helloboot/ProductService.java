package com.sk.helloboot;

public class ProductService {

	public Product regist(ProductAddRequest request) {
		return new Product(request.getName(), request.getPrice(), request.getPolicy());
	}
}