package com.lean.rest.apiEngine.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lean.rest.annotation.LazyComponent;
import lombok.Data;

import java.io.Serializable;

@LazyComponent
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "isbn",
        "message"
})
@Data
public class RemoveBookRequest implements Serializable {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("message")
    private String message;
    public RemoveBookRequest(String userId, String isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }


}
