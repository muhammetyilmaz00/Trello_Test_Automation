package com.trello.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    private static final Duration durationTimeout = Duration.ofSeconds(10);

    public static void scrollIntoViewByXpath(String xpath) {
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollIntoViewById(String id) {
        WebElement element = Driver.getDriver().findElement(By.id(id));
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitAndClickByXpath(String xpath) {
        scrollIntoViewByXpath(xpath);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), durationTimeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }

    public static void waitAndClickByID(String id) {
        scrollIntoViewById(id);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), durationTimeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
        element.click();
    }

    public static void waitAndSendKeysByXpath(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), durationTimeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.sendKeys(text);
    }

    public static void waitAndSendKeysByName(String name, String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), durationTimeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
        element.sendKeys(text);
    }

    public static boolean isElementDisplayedByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), durationTimeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element.isDisplayed();
    }

    public static void navigateURL(String URL) {
        Driver.getDriver().navigate().to(URL);
    }

    public static String getCurrentURL() {
        return Driver.getDriver().getCurrentUrl();
    }

}
