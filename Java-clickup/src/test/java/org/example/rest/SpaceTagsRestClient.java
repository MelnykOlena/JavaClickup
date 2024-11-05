
package org.example.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class SpaceTagsRestClient {

    private static final String BASE_URL = "https://api.clickup.com/api/v2/";

    public Response getSpaceTags() {
        return SerenityRest
                .given()
                .auth().oauth2("pk_152443084_285LSK4AJST9AVXGK670CE6NCP2OU7LP")
                .header("Content-Type", "application/json")
                .when()
                .get(BASE_URL + "space/90121631770/tag");
    }
}
