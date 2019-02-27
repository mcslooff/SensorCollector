package nl.tufa.sensor.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zkoss.web.util.resource.ClassWebResource;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.HttpSessionListener;
import org.zkoss.zk.ui.http.RichletFilter;

//@Configuration
public class ZKCEConfig {
	
	//@Controller
	//public class ZulForwardController {
	//	@RequestMapping(value = "/**/*.zul")
	//	public String handleTestRequest(HttpServletRequest request) {
	//		return "forward:" + "zkau" + ClassWebResource.PATH_PREFIX + "/zul" + request.getServletPath();
	//	}
	//}
	
	//@Bean
	public ServletRegistrationBean dHtmlUpdateServlet() {
		return new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/");
	}
	
	//@Bean
	public FilterRegistrationBean richletFilter() {
		FilterRegistrationBean reg = new FilterRegistrationBean(new RichletFilter());
		reg.addUrlPatterns("/richlet/");
		return reg;
	}
	
	//@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener();
	}
	
}
