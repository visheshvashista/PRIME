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
	


}
