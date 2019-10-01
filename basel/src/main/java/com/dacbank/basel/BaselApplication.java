package com.dacbank.basel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.dacbank.basel")
@EnableDiscoveryClient
public class BaselApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaselApplication.class, args);
	}
}
