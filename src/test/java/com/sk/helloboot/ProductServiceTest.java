package com.sk.helloboot;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.InitBinder;

import com.fasterxml.jackson.databind.Module.SetupContext;

public class ProductServiceTest {
	
	private ProductService productService;
	
	@BeforeEach
	void initTest() {
		productService = new ProductService();
	}

	@Test
	void addProduct() throws Exception {
		final String name = "상품명";
		final long price = 1000L;
		ProductAddRequest request = new ProductAddRequest(name, price, DiscountPolicy.NONE);
		//given
		Product product = productService.regist(request);
		//when
		//then
		assertThat(product.getName()).isEqualTo(name);
	}
}