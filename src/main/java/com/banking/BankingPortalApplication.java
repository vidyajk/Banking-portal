package com.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.banking"})
@ComponentScan(basePackages = {"com.banking"})
public class BankingPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingPortalApplication.class, args);
	}

}

