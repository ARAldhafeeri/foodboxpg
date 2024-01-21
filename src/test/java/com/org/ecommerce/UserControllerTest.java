package com.org.ecommerce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.ecommerce.modal.User;
import com.org.ecommerce.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    // Test user login endpoint
    @Test
    public void testUserLoginEndpoint() {
        // Prepare the login request object
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user@example.com");
        loginRequest.setPassword("password");

        // Send a POST request to the user login endpoint
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/user/login",
                new HttpEntity<>(loginRequest),
                User.class
        );

        // Assert the response
        Assert.assertEquals(responseEntity.getStatusCodeValue(), 302);
       }
}
