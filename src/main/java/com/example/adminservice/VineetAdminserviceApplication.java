package com.example.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.adminservice.proxy")
public class VineetAdminserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VineetAdminserviceApplication.class, args);
	}

}
