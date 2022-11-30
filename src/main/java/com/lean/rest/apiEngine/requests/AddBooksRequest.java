package com.lean.rest.apiEngine.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lean.rest.annotation.LazyComponent;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@LazyComponent
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userId", "collectionOfIsbns"})
@Generated("jsonschema2pojo")
public class AddBooksRequest implements Serializable {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("collectionOfIsbns")
    private List<ISBN> collectionOfIsbns;

    public AddBooksRequest(String userId, ISBN isbn) {
        this.userId = userId;
        collectionOfIsbns = new ArrayList<ISBN>();
        collectionOfIsbns.add(isbn);
    }

}


