package com.trello.utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TrelloApiClient {
    public static RequestSpecification requestSpecification;
    public static final String BOARDS_ENDPOINT = "boards/";

    /**
     * Set up the base URI and request specification for API calls
     */
    public static void setUp() {
        baseURI = PropertiesFactory.getPropertyFromApplication("baseURI");
        requestSpecification = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam("key", PropertiesFactory.getPropertyFromConfiguration("key"))
                .queryParam("token", PropertiesFactory.getPropertyFromConfiguration("token"));
    }
}