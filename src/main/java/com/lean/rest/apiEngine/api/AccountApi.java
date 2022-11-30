package com.lean.rest.apiEngine.api;

import com.lean.rest.annotation.LazyComponent;
import com.lean.rest.apiEngine.apiservices.Route;
import com.lean.rest.apiEngine.response.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;


@LazyComponent
public class AccountApi {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Route route;
    public ResponseEntity<UserAccount> getUserAccount(String userId) {
        return restTemplate.exchange(new RequestEntity<>(HttpMethod.GET, route.userAccount(userId).toUri()), UserAccount.class);
    }
}
