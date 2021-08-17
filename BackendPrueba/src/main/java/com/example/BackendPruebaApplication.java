package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class BackendPruebaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackendPruebaApplication.class, args);
	}
		
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BackendPruebaApplication.class);
	}
	
}
