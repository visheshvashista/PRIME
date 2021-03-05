package com.number.prime.unittests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.number.prime.controller.PrimeNumberController;
import com.number.prime.exception.CustomResponseEntityExceptionHandler;
import com.number.prime.exception.NoPrimeNumberException;
import com.number.prime.service.PrimeNumberService;
import com.number.prime.vo.PrimeNumber;

@ExtendWith(MockitoExtension.class)
public class PrimeNumberControllerUnitTest{

    @Mock
    PrimeNumberService primeNumberGenerator;

    @InjectMocks
    PrimeNumberController primeNumberController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(primeNumberController).
                setControllerAdvice(new CustomResponseEntityExceptionHandler()).build();
    }

    @Test
    public void testFailsWhenPathVariableNotValid() throws Exception {
        mockMvc.perform(get("/primemumberservice/" +"abc"))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void testFailsWhenPathVariableAbsent() throws Exception {
        mockMvc.perform(get("/primemumberservice/" +""))
                .andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void testWhenPathVariableValid() throws Exception {

        PrimeNumber inputNumber = new PrimeNumber("11") ;
        PrimeNumber expectedResult = new PrimeNumber("2,3,5,7,11");
        Mockito.when(primeNumberGenerator.generatePrimeNumbers(Mockito.anyLong())).thenReturn(expectedResult);
        MvcResult result =  mockMvc.perform(get("/primemumberservice/" + inputNumber))
                .andExpect(status().isOk())
                .andReturn();
        String actualOutput = result.getResponse().getContentAsString();
        Assert.assertEquals(expectedResult,actualOutput);

    }

    @Test
    public void testWhenPrimeNumberNotPresentForInput() throws Exception {
        String inputNumber = "1" ;
        Mockito.when(primeNumberGenerator.generatePrimeNumbers(Mockito.anyLong())).thenThrow(new NoPrimeNumberException("No prime number exists less than 1"));
        mockMvc.perform(get("/primemumberservice/" + inputNumber))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}