package com.billing.Billingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BillingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingsystemApplication.class, args);
	}

}
