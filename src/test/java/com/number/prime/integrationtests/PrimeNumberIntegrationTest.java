package com.number.prime.integrationtests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.number.prime.PrimeNumberApplication;

@SpringBootTest(classes = {PrimeNumberApplication.class} , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PrimeNumberIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testPrimeNumberGenerationSuccessResponse() {

        String inputNumber = "11" ;
        String expectedResult = "{\"primeNumber\":\"2,3,5,7,11\"}";
        HttpEntity<String> requestEntity = createHttpEntity();
        ResponseEntity<String > responseEntity= testRestTemplate.exchange("/primemumberservice/" + inputNumber, HttpMethod.GET,requestEntity,String.class);
        Assert.assertEquals(expectedResult,responseEntity.getBody());

    }

    @Test
    public void testPrimeNumberGenerationBadRequestInCaseInputInvalid() {
        String inputNumber = "ABC" ;
        HttpEntity<String> requestEntity = createHttpEntity();
        ResponseEntity<String > actual= testRestTemplate.exchange("/primemumberservice/" + inputNumber, HttpMethod.GET,requestEntity,String.class);
        Assert.assertEquals(actual.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private HttpEntity<String> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return requestEntity;
    }

}
