package com.deloitte.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingRegisterApplication.class, args);
	}

}
