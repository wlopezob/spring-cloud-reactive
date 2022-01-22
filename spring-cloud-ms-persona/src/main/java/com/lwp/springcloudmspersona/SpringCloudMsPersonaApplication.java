package com.lwp.springcloudmspersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudMsPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMsPersonaApplication.class, args);
	}

}
