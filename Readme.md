### Reference Documentation
This API generates prime numbers up till the input number.

Requirements:
java 1.8 
maven 3.2.x

Steps to build the application:

1. Extract the zip file and go to the extracted folder
2. Open terminal and go to the extracted folder and run following command
 
    mvn clean install

Steps to run the application:

1. Open terminal and go to the extracted folder and run following command.
   
    mvn spring-boot:run

Steps to run the tests :

1. Open terminal and go to the extracted folder and run following  command.
  
    mvn test


Swagger Link

http://localhost:8080/swagger-ui.html

API Endpoint:

http://localhost:8080/primemumberservice/{number}


Functionality

This API will return all the prime number up to the input number.

For any input less than number 2, this API returns HTTP code 404 and return following message "No prime numbers less than or equal to 1".

In case of Bad Arguments like Alphanumeric characters,  NumberFormat Exception is returned



