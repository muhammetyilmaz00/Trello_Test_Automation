package com.trello.stepDefinitions;

import com.trello.requests.CallService;
import com.trello.utils.TrelloApiClient;
import com.trello.utils.ContextStore;
import io.cucumber.java.en.And;
import org.junit.Assert;
import io.restassured.response.Response;


public class GetBoardStepDef extends TrelloApiClient {

    CallService callService = new CallService(requestSpecification);

    @And("I check the board is retrievable by its ID using the API")
    public void iCheckTheBoardIsRetrievableByItsIDUsingTheAPI() {
        String boardID = ContextStore.get("boardID");

        Response response = callService.executeGetRequest(BOARDS_ENDPOINT + boardID);
        Assert.assertEquals(200, response.getStatusCode());
    }

}
