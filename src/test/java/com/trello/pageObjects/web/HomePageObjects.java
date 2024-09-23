package com.trello.pageObjects.web;

import com.trello.pageObjects.interfaces.HomePageObjectsInterface;
import com.trello.utils.Helper;

public class HomePageObjects implements HomePageObjectsInterface {

    @Override
    public boolean isBoardDisplayed(String name) {
        return Helper.isElementDisplayedByXpath("//*[@class='boards-page-board-section-list']//div[@title='"+name+"']");
    }

    @Override
    public void createBoard(String name) {
        Helper.waitAndClickByXpath("//p[text()='Create']");
        Helper.waitAndClickByXpath("//button[@data-testid='header-create-board-button']");
        Helper.waitAndSendKeysByXpath("//input[@data-testid='create-board-title-input']", name);
        Helper.waitAndClickByXpath("//button[@data-testid='create-board-submit-button']");
    }
}
