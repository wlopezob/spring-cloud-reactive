package com.lwp.springcloudmsdiscoverregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudMsDiscoverRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMsDiscoverRegisterApplication.class, args);
	}

}
