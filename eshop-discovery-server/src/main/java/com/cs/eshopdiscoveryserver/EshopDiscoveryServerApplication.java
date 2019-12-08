package com.cs.eshopdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

@EnableEurekaServer
public class EshopDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopDiscoveryServerApplication.class, args);
	}

}
