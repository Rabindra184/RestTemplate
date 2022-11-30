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
        "isbn"
})
@Data
public class ISBN implements Serializable {
    @JsonProperty("isbn")
    private String isbn;

    public ISBN(String isbn) {
        this.isbn = isbn;
    }
}