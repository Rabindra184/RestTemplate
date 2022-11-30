package com.lean.rest.configuration;

import com.lean.rest.service.TokenManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@Service
@Configurable
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
    private final String AUTHORIZATION = "Authorization";
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TokenManager tokenManager;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        request.getHeaders().set("Accept", MediaType.APPLICATION_JSON_VALUE);
        ClientHttpResponse response = execution.execute(request, body);
        if (HttpStatus.UNAUTHORIZED == response.getStatusCode()) {
            String accessToken = tokenManager.getToken();
            if (!StringUtils.isEmpty(accessToken)) {
                request.getHeaders().remove(AUTHORIZATION);
                request.getHeaders().add(AUTHORIZATION, "Bearer " + accessToken);
            }
        }
        logResponse(response);
        response.getHeaders().add("headerName", "VALUE");
        return execution.execute(request, body);
    }


    private void logRequest(HttpRequest request, byte[] body) throws IOException {

        log.info("===========================request begin================================================");
        log.info("URI         : {}", request.getURI());
        log.info("Method      : {}", request.getMethod());
        log.info("Headers     : {}", request.getHeaders());
        log.info("Request body: {}", new String(body, StandardCharsets.UTF_8));
        log.info("==========================request end================================================");

    }

    private void logResponse(ClientHttpResponse response) throws IOException {

        log.info("============================response begin==========================================");
        log.info("Status code  : {}", response.getStatusCode());
        log.info("Status text  : {}", response.getStatusText());
        log.info("Headers      : {}", response.getHeaders());
        log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        log.info("=======================response end=================================================");
    }


}
