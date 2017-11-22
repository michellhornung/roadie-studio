package com.hornung.roadiestudio.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
							new ErrorPage(HttpStatus.FORBIDDEN, "/403")));
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addRedirectViewController("/", "/home");
		registry.addViewController("/error/403").setViewName("403");
	}

	
}