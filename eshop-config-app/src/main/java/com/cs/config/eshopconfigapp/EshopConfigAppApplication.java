package com.cs.config.eshopconfigapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class EshopConfigAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(EshopConfigAppApplication.class, args);
	}
}
