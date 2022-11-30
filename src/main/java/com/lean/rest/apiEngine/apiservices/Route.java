package com.lean.rest.apiEngine.apiservices;

import com.lean.rest.annotation.LazyComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@LazyComponent
public class Route {
    public static final String BOOKSTORE = "BookStore";
    public static final String ACCOUNT = "Account";
    public static final String BASE_PATH = "v1";
    public static final String GENERATETOKEN = "GenerateToken";
    public static final String BOOKS = "Books";
    public static final String BOOK = "Book";
    public static final String USER = "User";
    public static final String Authorized = "Authorized";
    @Value("${baseUrl}")
    private String base;

    public UriComponents getBooks() {
        return UriComponentsBuilder.fromHttpUrl(base).path(BOOKSTORE + "/" + BASE_PATH + "/" + BOOKS).build();

    }

    public UriComponents getBook() {
        return UriComponentsBuilder.fromHttpUrl(base).path(BOOKSTORE + "/" + BASE_PATH + "/" + BOOK).build();

    }

    public UriComponents userAccount(String userId) {
        return UriComponentsBuilder.fromHttpUrl(base).path(ACCOUNT + "/" + BASE_PATH + "/" + USER + "/" + userId).build();
    }

    public UriComponents generateToken() {
        return UriComponentsBuilder.fromHttpUrl(base).path(ACCOUNT + "/" + BASE_PATH + "/" + GENERATETOKEN).build();
    }

}
