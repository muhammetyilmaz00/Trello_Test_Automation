package com.trello.pageObjects.web;

import com.trello.pageObjects.interfaces.BoardPageObjectsInterfaces;
import com.trello.utils.Helper;

public class BoardPageObjects implements BoardPageObjectsInterfaces {

    @Override
    public boolean isBoardDisplayedInYourBoardsList(String name) {
        return Helper.isElementDisplayedByXpath("//div[@data-testid='collapsible-list']//a[@title='" + name + " (currently active)']");
    }

    @Override
    public String getBoardIDFromUrl() {
        String url = Helper.getCurrentURL();
        return url.substring(url.indexOf("b/") + 2, url.lastIndexOf("/"));
    }

}
