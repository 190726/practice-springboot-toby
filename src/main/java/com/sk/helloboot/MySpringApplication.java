package com.sk.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
	
	public static void run(Class<?> applicationClass, String... args) {
		//스프링 컨테이너 초기화 메서드 내에 서블릿컨테이너 생성 삽입
    	AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();
				
				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
		    	WebServer webServer = serverFactory.getWebServer(servletContext ->{
		    		//DispatcherServlet으로 변경
		    		servletContext.addServlet("hello", dispatcherServlet).addMapping("/*");
				});
		    	webServer.start();
			}
    	};
    	
    	//빈팩토리 매서드가 있는 java설정정보 등록
    	applicationContext.register(applicationClass);
    	applicationContext.refresh();//스프링 컨테이너 초기화
	}

}
