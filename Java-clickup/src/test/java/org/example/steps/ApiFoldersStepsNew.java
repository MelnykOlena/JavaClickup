package org.example.steps;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.utils.RandomData;
import org.example.utils.ResourceUtils;
import org.json.JSONObject;

public class ApiFoldersStepsNew extends  BaseSteps{

    @Given("Sent request to get folders")
    public void getAllFolder() {
        Response response = foldersRestClient.getFolders();
        sharedTestData.setResponse(response);
    }

    @When("Create folder form file {}")
    public void createFolderFromFile(String path){
        RandomData randomData = new RandomData();
        String randomName = "my folder" + randomData.generateRandomString(7);
        String source = "data/folders/" + path;
        JSONObject body = ResourceUtils.readJson(source);
//        body.put("name", randomName );
        Response response = foldersRestClient.postFolderFromFile(body.toString());
        sharedTestData.setResponse(response);



    }
}
