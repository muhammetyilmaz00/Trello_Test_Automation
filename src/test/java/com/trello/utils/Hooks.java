package com.trello.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static io.restassured.RestAssured.reset;

public class Hooks {
    private static Scenario scenario;

    public static String getScenarioName() {
        return scenario.getName();
    }

    /**
     * It is executed before each test case.
     * It initializes the test environment by calling the setUp() method from the TrelloApiClient class.
     * It also sets the current scenario, configures the logging properties, and logs the start of the scenario
     */
    @Before
    public static void init(Scenario scenario) {
        TrelloApiClient.setUp();
        Hooks.scenario = scenario;

        // Load Log4j configuration file
        Configurator.initialize(null, "src/test/resources/config/log4j2.xml");

        LogUtils.info("Started Scenario: " + getScenarioName());
    }

    /**
     * It resets the RestAssured values and logs an info message with the name of the scenario
     */
    @After
    public static void tearDown() {
        reset();
        LogUtils.info("Finished Scenario: " + getScenarioName());
    }

    /**
     * It takes a screenshot if the scenario fails and then closes the browser
     */
    @After(value = "@UI")
    public static void closeBrowser() {
        if (scenario.isFailed()) {
            final byte[] screenshot = (
                    (TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }
}
