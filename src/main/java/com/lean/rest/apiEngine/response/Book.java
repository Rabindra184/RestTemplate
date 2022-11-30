package com.lean.rest.apiEngine.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isbn",
        "title",
        "subTitle",
        "author",
        "publish_date",
        "publisher",
        "pages",
        "description",
        "website"
})
@Generated("jsonschema2pojo")
public class Book implements Serializable {

    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subTitle")
    private String subTitle;
    @JsonProperty("author")
    private String author;
    @JsonProperty("publish_date")
    private String publishDate;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("description")
    private String description;
    @JsonProperty("website")
    private String website;
}