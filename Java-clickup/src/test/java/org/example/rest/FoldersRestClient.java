package org.example.rest;

import io.restassured.response.Response;

public class FoldersRestClient extends BaseRestClient {
    String foldersUrl = "space/90152363684/folder";

    public FoldersRestClient() {
        this.setUpRestAssured();
    }

    public Response getFolders() {
        return this.requestSpec.get(foldersUrl);
    }

    public Response postFolderFromFile(String payload) {
        return this.requestSpec
                .body(payload)
                .post(foldersUrl);
    }


}
