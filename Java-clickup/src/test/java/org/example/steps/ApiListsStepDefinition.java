package org.example.steps;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiListsStepDefinition {

    String token = "pk_62686931_IIJURLQ4BVJWIFYESRUJR3NC9I55D56T";
    String baseUrl = "https://api.clickup.com/api/v2";

    @Given("Sent request to get list")
    public void getListS() {
        SerenityRest.given()
                .baseUri(baseUrl)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .when()
                .get("/folder/90153624098/list")
                .then()
                .statusCode(200);
    }

    @Given("Sent request to get list and get list id")
    public void getListIdFromResponse() {
        String response =  SerenityRest.given()
                .baseUri(baseUrl)
                .header("Authorization", token)
                .header("Content-Type", "application/json")
                .get("/folder/90153624098/list")
                .then()
                .extract()
                .body()
                .asString();
        JSONObject obj = new JSONObject(response);
        JSONArray listArray = obj.getJSONArray("lists");
        JSONObject list = listArray.getJSONObject(0);
        String id = list.getString("id");
        System.out.println(id);

    }
}
