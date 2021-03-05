package com.number.prime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.number.prime.service.PrimeNumberService;
import com.number.prime.vo.PrimeNumber;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@Tag(name = "primemumberservice", description = "This API returns prime numbers less than the input number.")
@OpenAPIDefinition(info = @Info(title = "prime number api", version = "1.0", description = "This api returns prime number less than or equal to input number"))
public class PrimeNumberController {
	
	private final static Logger log = LoggerFactory.getLogger(PrimeNumberController.class);

	@Autowired
	PrimeNumberService primeNumberGenerator;
	
	@GetMapping(path="primemumberservice/{number}")
	public PrimeNumber  getPrimeNumbers(@PathVariable(value = "number") Long number) {
		 log.info("call primenumberservice to get prime number under  {}", number);
		 return primeNumberGenerator.generatePrimeNumbers(number)  ;
	  }
}
