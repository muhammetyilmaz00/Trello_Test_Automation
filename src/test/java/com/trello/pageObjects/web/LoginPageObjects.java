package com.trello.pageObjects.web;

import com.trello.pageObjects.interfaces.LoginPageObjectsInterface;
import com.trello.utils.Helper;
import com.trello.utils.PropertiesFactory;

public class LoginPageObjects implements LoginPageObjectsInterface {

    @Override
    public void login(String username, String password) {
        Helper.waitAndClickByXpath("//div[@data-active='false']//*[text()='Log in']");
        Helper.waitAndSendKeysByName("username", PropertiesFactory.getPropertyFromConfiguration("username"));
        Helper.waitAndClickByID("login-submit");
        Helper.waitAndSendKeysByName("password", PropertiesFactory.getPropertyFromConfiguration("password"));
        Helper.waitAndClickByID("login-submit");
    }
}
