package com.sk.helloboot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class App 
{
    public static void main( String[] args )
    {
    	GenericApplicationContext applicationContext = new GenericApplicationContext();
    	applicationContext.registerBean(HelloController.class);
    	applicationContext.registerBean(SimpleHelloService.class);
    	applicationContext.refresh();//스프링 컨테이너 기동
    	
    	TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    	WebServer webServer = serverFactory.getWebServer(servletContext ->{
    		
    		//프론트 컨트롤러 방식
    		
    		servletContext.addServlet("hello", new HttpServlet() {
				private static final long serialVersionUID = -1527783874696319821L;
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp)
						throws ServletException, IOException {
					//요청URI주소에 따라 controller 매핑
					if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
						String name = req.getParameter("name");
						
						HelloController helloController = applicationContext.getBean(HelloController.class);
						String ret = helloController.hello(name);
						//resp.setStatus(HttpStatus.OK.value()); 오류 없으면 서블릿컨테이너에서 200으로 자동 셋팅
						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
					}else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");
		});
    	webServer.start();
    }
}