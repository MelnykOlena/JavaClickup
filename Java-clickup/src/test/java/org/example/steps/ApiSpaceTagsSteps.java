
package org.example.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.example.rest.SpaceTagsRestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;



public class ApiSpaceTagsSteps {

    private static final String AUTH_TOKEN = "pk_152443084_285LSK4AJST9AVXGK670CE6NCP2OU7LP"; // Замість "ваш_реальний_токен" вкажіть фактичний токен

    @Given("valid authorization token")
    public void valid_authorization_token() {
        SerenityRest.given().header("Authorization", "Bearer " + AUTH_TOKEN);
    }

    @When("request to get space tags")
    public void request_to_get_space_tags() {
        SerenityRest.given()
                .get("https://api.clickup.com/api/v2/space/90121631770/tag")
                .then().statusCode(200);
    }

    @Then("response with the list of space tags")
    public void response_with_the_list_of_space_tags() {
        int statusCode = SerenityRest.then().extract().statusCode();
        Assertions.assertEquals(200, statusCode);
    }

    @When("request to create a space tag")
    public void request_to_create_space_tag() {
        SerenityRest.given()
                .body("{\n" +
                        "  \"tag\": {\n" +
                        "    \"name\": \"Tag Name\",\n" +
                        "    \"tag_fg\": \"#000000\",\n" +
                        "    \"tag_bg\": \"#000000\"\n" +
                        "  }\n" +
                        "}")
                .post("https://api.clickup.com/api/v2/space/90121631770/tag")
                .then().statusCode(201);
    }

    @Then("response with the created space tag")
    public void response_with_the_created_space_tag() {
        int statusCode = SerenityRest.then().extract().statusCode();
        Assertions.assertEquals(201, statusCode);
    }
}