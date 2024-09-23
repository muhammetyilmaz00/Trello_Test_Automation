package com.trello.stepDefinitions;

import com.trello.requests.CallService;
import com.trello.utils.TrelloApiClient;
import com.trello.utils.ContextStore;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.junit.Assert;

public class DeleteBoardStepDef extends TrelloApiClient {

    CallService callService = new CallService(requestSpecification);

    @And("I delete the board")
    public void iDeleteTheBoard() {
        String boardID = ContextStore.get("boardID");

        Response response = callService.executeDeleteRequest(BOARDS_ENDPOINT, boardID);
        Assert.assertEquals(200, response.getStatusCode());
    }
}
