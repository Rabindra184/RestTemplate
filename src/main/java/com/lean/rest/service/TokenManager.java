package com.lean.rest.service;

import com.lean.rest.annotation.LazyComponent;
import com.lean.rest.apiEngine.apiservices.Route;
import com.lean.rest.apiEngine.requests.AuthorizationRequest;
import com.lean.rest.apiEngine.response.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@LazyComponent
@Configuration
public class TokenManager {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private String access_token;
    private Instant expiry_time;
    @Autowired
    private AuthorizationRequest authRequest;
    @Autowired
    private Route route;

    public synchronized String getToken() {
        try {
            if (access_token == null || Instant.now().isAfter(expiry_time)) {
                System.out.println("Renewing token ...");
                Token token = renewToken();
                access_token = token.getToken();
                expiry_time = Instant.parse(token.getExpires()).minusSeconds(600);
            } else {
                log.info("Token is good to use");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ABORT!!! Failed to get token");
        }
        return access_token;
    }

    private Token renewToken() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Token> response = restTemplate.exchange(route.generateToken().toUriString(), HttpMethod.POST, new HttpEntity<>(authRequest), Token.class);
        if (response.getStatusCodeValue() != org.apache.http.HttpStatus.SC_OK)
            throw new RuntimeException("Authentication Failed. Content of failed Response: " + response + " , Status Code : " + response.getStatusCodeValue());
        return response.getBody();
    }

}
