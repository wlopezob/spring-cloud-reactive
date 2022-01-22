package com.lwp.springcloudmsinternalgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudMsInternalGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMsInternalGatewayApplication.class, args);
	}

}
