package com.cs.eshop.springbooteshopzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class SpringBootEShopZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEShopZuulApplication.class, args);
	}
}
