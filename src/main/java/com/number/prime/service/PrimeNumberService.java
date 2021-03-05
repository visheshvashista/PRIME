package com.number.prime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;

import com.number.prime.exception.NoPrimeNumberException;
import com.number.prime.vo.PrimeNumber;

@Service

public class PrimeNumberService {

	private final static Logger log = LoggerFactory.getLogger(PrimeNumberService.class);

	@Cacheable(value = "primeNumberCache", key = "#number")
	public PrimeNumber generatePrimeNumbers(Long number) {

		Long inputNumber = number;

		if (inputNumber <= 1)
			throw new NoPrimeNumberException("No prime numbers less than or equal to " + inputNumber.toString());

		PrimeNumber primenumbersList = new PrimeNumber(getPrimeNumber(inputNumber));
		log.info("prime number under {} is {}", number, primenumbersList.toString());
		return primenumbersList;
		
	}

	// return string of prime numbers
	private String getPrimeNumber(long inNumber) {
		
		String primeNumbersList = "";
		
		for (Long i = 2L; i <= inNumber; i++) {
			
			if (isPrime(i))
				if (primeNumbersList == "") 
					primeNumbersList = i.toString();
				else 
					primeNumbersList = primeNumbersList + "," + i.toString();	
			
		}
		return primeNumbersList;
	}

	// check whether number is prime
	private boolean isPrime(long inNumber) {
		
		for (int i = 2; i < inNumber; i++)
			if (inNumber % i == 0)
				return false;
			
				
		return true;

	}


}
