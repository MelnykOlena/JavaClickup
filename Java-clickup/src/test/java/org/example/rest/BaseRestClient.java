package org.example.rest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public abstract class BaseRestClient {
    private String token = "pk_62686931_IIJURLQ4BVJWIFYESRUJR3NC9I55D56T";
    private String baseUrl = "https://api.clickup.com/api/v2";

    protected RequestSpecification requestSpec;

    public void setUpRestAssured(){
        this.requestSpec = SerenityRest.given()
                .baseUri(this.baseUrl)
                .header("Authorization", token)
                .contentType(ContentType.JSON);
    }
}
