package com.lean.rest.apiEngine.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "books"
})
public class Books implements Serializable {

    @JsonProperty("books")
    private List<Book> books = null;

    @JsonProperty("books")
    public List<Book> getBooks() {
        return books;
    }

    @JsonProperty("books")
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
