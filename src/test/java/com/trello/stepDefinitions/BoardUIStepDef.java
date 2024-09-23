package com.trello.stepDefinitions;

import com.trello.pageObjects.web.BoardPageObjects;
import com.trello.pageObjects.web.HomePageObjects;
import com.trello.pageObjects.web.LoginPageObjects;
import com.trello.utils.ContextStore;
import com.trello.utils.Driver;
import com.trello.utils.Helper;
import com.trello.utils.PropertiesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BoardUIStepDef {

    LoginPageObjects loginPageObjects = new LoginPageObjects();
    HomePageObjects homePageObjects = new HomePageObjects();
    BoardPageObjects boardPageObjects = new BoardPageObjects();

    @When("I log into Trello via the UI")
    public void iLogIntoTrelloViaTheUI() {
        Driver.getDriver();
        Helper.navigateURL(PropertiesFactory.getPropertyFromApplication("baseURL"));

        loginPageObjects.login(PropertiesFactory.getPropertyFromConfiguration("username"), PropertiesFactory.getPropertyFromConfiguration("password"));
    }

    @Then("I check the board {string} is on the Trello homepage")
    public void iCheckTheBoardIsOnTheTrelloHomepage(String name) {
        Assert.assertTrue(homePageObjects.isBoardDisplayed(name));
    }

    @And("I create a Trello board named {string} via the UI")
    public void iCreateATrelloBoardNamedViaTheUI(String name) {
        homePageObjects.createBoard(name);
    }

    @Then("I check the board {string} is visible on the Trello homepage")
    public void iCheckTheBoardIsVisibleOnTheTrelloHomepage(String name) {
        Assert.assertTrue(boardPageObjects.isBoardDisplayedInYourBoardsList(name));
        ContextStore.put("boardID", boardPageObjects.getBoardIDFromUrl());
    }
}
