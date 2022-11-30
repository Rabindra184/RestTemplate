package com.lean.rest.stepDefinitions;

import com.lean.rest.apiEngine.response.Book;
import com.lean.rest.apiEngine.response.Books;
import com.lean.rest.apiEngine.response.UserAccount;
import com.lean.rest.context.TestContext;
import com.lean.rest.enums.Context;
import io.cucumber.java.en.Then;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import java.util.Objects;

public class VerificationSteps extends BaseStep {

    public VerificationSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("the book is added")
    public void bookIsAdded() {
        System.out.println(scenarioContext);
        Book book = (Book) scenarioContext.getContext(Context.BOOK);
        System.out.println(book.getIsbn());
        ResponseEntity<Books> BooksResponse = (ResponseEntity<Books>) scenarioContext.getContext(Context.BOOKS);
        Assert.assertEquals(201, BooksResponse.getStatusCodeValue());
        Assert.assertEquals(book.getIsbn(), Objects.requireNonNull(BooksResponse.getBody()).getBooks().get(0).getIsbn());
    }

    @Then("the book is removed")
    public void bookIsRemoved() {
        System.out.println(scenarioContext);
        String userId = (String) scenarioContext.getContext(Context.USER_ID);
        System.out.println(userId);
        ResponseEntity response = (ResponseEntity) scenarioContext.getContext(Context.BOOK_REMOVE_RESPONSE);
        Assert.assertEquals(response.getStatusCodeValue(), 204);
        ResponseEntity<UserAccount> userAccountResponse = null;
        userAccountResponse = accountApi.getUserAccount(userId);
        Assert.assertEquals(200, userAccountResponse.getStatusCodeValue());
        Assert.assertEquals(0, Objects.requireNonNull(userAccountResponse.getBody()).getBooks().size());
    }


}