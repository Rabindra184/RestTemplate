package com.lean.rest.apiEngine.api;

import com.lean.rest.annotation.LazyComponent;
import com.lean.rest.apiEngine.apiservices.Route;
import com.lean.rest.apiEngine.requests.AddBooksRequest;
import com.lean.rest.apiEngine.requests.RemoveBookRequest;
import com.lean.rest.apiEngine.response.Books;
import com.lean.rest.apiEngine.response.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@LazyComponent
public class BookStoreApi {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Route route;

    public ResponseEntity<Books> getBooks() {

        return restTemplate.exchange(new RequestEntity<>(HttpMethod.GET, route.getBooks().toUri()), Books.class);
    }
    public ResponseEntity<Books> addBook(AddBooksRequest addBooksRequest) {
        return restTemplate.exchange(route.getBooks().toUriString(), HttpMethod.POST, new HttpEntity<>(addBooksRequest), Books.class);
    }
    public ResponseEntity removeBook(RemoveBookRequest removeBookRequest) {

        return restTemplate.exchange(route.getBook().toUriString(), HttpMethod.DELETE, new HttpEntity<>(removeBookRequest), Object.class);

    }
    public ResponseEntity<UserAccount> getUserAccount(String USER_ID) {
        return restTemplate.exchange(new RequestEntity<>(HttpMethod.GET, (route.userAccount(USER_ID).toUri())), UserAccount.class);
    }
}
