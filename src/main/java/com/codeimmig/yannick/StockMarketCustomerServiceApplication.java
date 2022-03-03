package com.codeimmig.yannick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class StockMarketCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketCustomerServiceApplication.class, args);
	}

}
