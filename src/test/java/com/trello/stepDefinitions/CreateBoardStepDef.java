package com.trello.stepDefinitions;

import com.trello.pojo.Board;
import com.trello.requests.CallService;
import com.trello.utils.TrelloApiClient;
import com.trello.utils.ContextStore;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class CreateBoardStepDef extends TrelloApiClient {

    CallService callService = new CallService(requestSpecification);


    @Given("I create a Trello board named {string} via the API")
    public void iCreateATrelloBoardNamedViaTheAPI(String boardName) {
        Response response = callService.executePostRequest(BOARDS_ENDPOINT, Map.of("name", boardName));
        Assert.assertEquals(200, response.getStatusCode());

        // stores the boardID for further use in the test
        Board board = response.as(Board.class);
        ContextStore.put("boardID", board.getId());
    }

}
