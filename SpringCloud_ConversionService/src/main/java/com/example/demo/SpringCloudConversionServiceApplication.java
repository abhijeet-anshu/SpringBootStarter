package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages="com")
@EnableFeignClients(basePackages="com")
@EnableDiscoveryClient
public class SpringCloudConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConversionServiceApplication.class, args);
	}

}
