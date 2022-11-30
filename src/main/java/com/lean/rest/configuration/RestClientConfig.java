package com.lean.rest.configuration;

import com.lean.rest.apiEngine.requests.AuthorizationRequest;
import com.lean.rest.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestClientConfig {
    @Autowired
    private RestTemplateHeaderModifierInterceptor restTemplateHeaderModifierInterceptor;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setOutputStreaming(false);
        restTemplate.setRequestFactory(requestFactory);
        List<ClientHttpRequestInterceptor> interceptors
                = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(restTemplateHeaderModifierInterceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
