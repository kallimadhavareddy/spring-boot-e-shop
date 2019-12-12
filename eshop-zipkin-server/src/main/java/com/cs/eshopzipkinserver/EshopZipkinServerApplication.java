package com.cs.eshopzipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*@EnableZipkinServer*/ //todo zipkin server is not working in spring boot 2 i have to find thee rooot cause
public class EshopZipkinServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EshopZipkinServerApplication.class, args);
	}
	/*@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}*/
}
