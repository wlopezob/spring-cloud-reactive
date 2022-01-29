package com.bsoftgroup.springcloudmssecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudMsSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMsSecurityApplication.class, args);
	}

}
