package com.number.prime.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.number.prime.exception.NoPrimeNumberException;
import com.number.prime.service.PrimeNumberService;
import com.number.prime.vo.PrimeNumber;


public class PrimeNumberGeneratorUnitTest {
	@Autowired
    PrimeNumberService primeNumberGenerator;
	PrimeNumber expectedResult;
	
    @BeforeEach                                         
    public void setUp() throws Exception {
    	primeNumberGenerator = new PrimeNumberService();
    }
	
	@Test
	public void getPrimeNumbersUnderZero() throws Exception {
		Assertions.assertThrows(NoPrimeNumberException.class, () -> {
			primeNumberGenerator.generatePrimeNumbers(0L);});
		 }

    @Test
	public void getPrimeNumbersUnderOne() throws Exception {
		Assertions.assertThrows(NoPrimeNumberException.class, () -> {
			primeNumberGenerator.generatePrimeNumbers(1L);});
	}

	@Test
	public void getPrimeNumbersNegative() throws Exception {
		Assertions.assertThrows(NoPrimeNumberException.class, () -> {
			primeNumberGenerator.generatePrimeNumbers(-1001L);});
	}

	@Test
	public void getPrimeNumbersUnderEleven() throws Exception {
		expectedResult = new PrimeNumber("2,3,5,7,11");
		PrimeNumber primeNumberList = primeNumberGenerator.generatePrimeNumbers(11L);
		Assertions.assertEquals(expectedResult,primeNumberList);
	}

	@Test
	public void getPrimeNumbersUnderHundred() throws Exception {
		expectedResult = new PrimeNumber("2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97");
		PrimeNumber primeNumberList = primeNumberGenerator.generatePrimeNumbers(100L);
		Assertions.assertEquals(expectedResult,primeNumberList);
	}

	@Test
	public void getPrimeNumbersUnderTwoHundred() throws Exception {
		expectedResult = new PrimeNumber("2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59");
		PrimeNumber primeNumberList = primeNumberGenerator.generatePrimeNumbers(200L);
		Assertions.assertNotEquals(expectedResult,primeNumberList);
	}

}
