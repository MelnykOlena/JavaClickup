package org.example.steps;

import org.example.data.SharedTestData;
import org.example.rest.FoldersRestClient;
import org.example.rest.ListRestClient;

public class BaseSteps {
    protected FoldersRestClient foldersRestClient = new FoldersRestClient();
    protected ListRestClient listRestClient = new ListRestClient();
    protected static SharedTestData sharedTestData = new SharedTestData();

}
