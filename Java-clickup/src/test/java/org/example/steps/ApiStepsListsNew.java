package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class ApiStepsListsNew extends BaseSteps {

    Response response;

    @Given("Sent request to get all lists")
    public void getAllLists() {
        this.response = listRestClient.getLists();
        sharedTestData.setResponse(response);

    }

}
