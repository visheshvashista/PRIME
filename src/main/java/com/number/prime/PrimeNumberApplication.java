package com.number.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.number.prime")
public class PrimeNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumberApplication.class, args);
	}

}
