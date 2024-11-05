
package org.example.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class CreateSpaceTagClient {

    private static final String BASE_URL = "https://api.clickup.com/api/v2/";

    public Response createSpaceTag() {
        return SerenityRest
                .given()
                .auth().oauth2("pk_152443084_285LSK4AJST9AVXGK670CE6NCP2OU7LP")
                .header("Content-Type", "application/json")
                .body("{" +
                        "  tag: {" +
                        "    name: Tag Name,"+
                        "    tag_fg: #000000," +
                        "    tag_bg: #000000" +
                        "  }" +
                        "}")
                .when()
                .post(BASE_URL + "space/90121631770/tag");
    }
}
