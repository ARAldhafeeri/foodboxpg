package com.org.ecommerce;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.ecommerce.requests.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper; // ObjectMapper to convert Java objects to JSON and vice versa

    // Test login endpoint
    @Test
    public void testLoginEndpoint() {
        // Prepare the login request object
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user");
        loginRequest.setPassword("test");

        // Send a POST request to the login endpoint
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/admin/login",
                new HttpEntity<>(loginRequest),
                String.class
        );

    }

}