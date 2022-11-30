package com.lean.rest.apiEngine.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lean.rest.annotation.LazyComponent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.io.Serializable;

@Data
@Component
@ComponentScan
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userName",
        "password"
})
@Generated("jsonschema2pojo")
public class AuthorizationRequest implements Serializable {
    @Value("${username}")
    @JsonProperty("userName")
    private String userName;

    @Value("${password}")
    @JsonProperty("password")
    private String password;

}




