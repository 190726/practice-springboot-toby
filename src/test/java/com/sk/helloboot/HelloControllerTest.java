package com.sk.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {
	
	@Test
	void helloController() {
		//HelloService가 정상 동작하는지까지는 테스트 할 필요 없으므로, 임의동작하는 파라미터를 넣어준다.
		HelloController helloController = new HelloController(name -> name);
		
		String ret = helloController.hello("Test");
		
		Assertions.assertThat(ret).isEqualTo("Test");
	}
	
	@Test
	void failHelloController() {
		HelloController helloController = new HelloController(name -> name);
		
		Assertions.assertThatThrownBy(()->{
			helloController.hello("");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
