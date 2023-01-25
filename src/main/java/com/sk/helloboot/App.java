package com.sk.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class App 
{
	@Bean
	public HelloController helloController(HelloService helloService) {
		return new HelloController(helloService);
	}
	
	@Bean
	public HelloService helloService() {
		return new SimpleHelloService();
	}

    public static void main( String[] args )
    {
    	//스프링 컨테이너 초기화 메서드 내에 서블릿컨테이너 생성 삽입
    	AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();
				TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		    	WebServer webServer = serverFactory.getWebServer(servletContext ->{
		    		
		    		//DispatcherServlet으로 변경
		    		servletContext.addServlet("hello", new DispatcherServlet(this)).addMapping("/*");
				});
		    	webServer.start();
			}
    	};
    	
    	//빈팩토리 매서드가 있는 java설정정보 등록
    	applicationContext.register(App.class);
    	applicationContext.refresh();//스프링 컨테이너 초기화
    }
}