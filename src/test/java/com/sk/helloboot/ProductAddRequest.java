package com.sk.helloboot;

import static org.springframework.util.Assert.hasText;

import org.springframework.util.Assert;

public class ProductAddRequest {

	private String name;
	private long price;
	private DiscountPolicy policy;

	public ProductAddRequest(String name, long price, DiscountPolicy policy) {
		hasText(name, "상품명은 필수 입니다.");
		Assert.isTrue(price > 0, "가격은 0원 이상입니다.");
		Assert.notNull(policy, "할인정책은 필수입니다.");
		
		this.name = name;
		this.price = price;
		this.policy = policy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public DiscountPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(DiscountPolicy policy) {
		this.policy = policy;
	}
	
	
}