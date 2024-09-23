package com.trello.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CallService {

    private final RequestSpecification requestSpecification;

    public CallService(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * This method performs a GET request to a specified endpoint.
     * It can log both the request details and the response body if needed for debugging or analysis.
     * The boolean flags logRequest and logResponse control whether these logs are generated or not.
     * The method returns the response from the GET request for further processing
     */
    public Response executeGetRequest(String endpoint, boolean logRequest, boolean logResponse) {
        RequestSpecification requestSpec = given(requestSpecification);

        if (logRequest)
            requestSpec.log().all();

        Response response = requestSpec
                .when()
                .get(endpoint);

        if (logResponse)
            response.then().log().body();

        return response;
    }

    public Response executeGetRequest(String endpoint) {
        // Default behavior: no request or response logging
        return executeGetRequest(endpoint, false, false);
    }

    public Response executeGetRequest(String endpoint, boolean logRequest) {
        // Default response logging behavior: no response logging
        return executeGetRequest(endpoint, logRequest, false);
    }

    /**
     * This method is for making a POST request to a specified endpoint with optional logging of request details and the response body.
     * It takes a Map of query parameters, and the boolean flags logRequest and logResponse determine whether to log request details and response body.
     * The method returns the response from the POST request for further processing.
     */
    public Response executePostRequest(String endpoint, Map<String, Object> queryParams, boolean logRequest, boolean logResponse) {
        RequestSpecification requestSpec = given(requestSpecification);

        if (logRequest)
            requestSpec.log().all();

        Response response = requestSpec
                .queryParams(queryParams)
                .when()
                .post(endpoint);

        if (logResponse)
            response.then().log().body();

        return response;
    }

    public Response executePostRequest(String endpoint, Map<String, Object> queryParams) {
        // Default behavior: no request or response logging
        return executePostRequest(endpoint, queryParams,false, false);
    }

    public Response executePostRequest(String endpoint, Map<String, Object> queryParams, boolean logRequest) {
        // Default response logging behavior: no response logging
        return executePostRequest(endpoint, queryParams, logRequest, false);
    }

    /**
     * This method is used to send a DELETE request to a specified endpoint, which includes an boardId as a path parameter.
     * It returns the response from the DELETE request, allowing further processing if needed.
     */
    public Response executeDeleteRequest(String endpoint, String boardId, boolean logRequest, boolean logResponse) {
        RequestSpecification requestSpec = given(requestSpecification);

        if (logRequest)
            requestSpec.log().uri().log().body();

        Response response =  requestSpec
                .when()
                .delete(endpoint + boardId);

        if (logResponse)
            response.then().log().body();
        return response;
    }
    
    public Response executeDeleteRequest(String endpoint, String boardId) {
        // Default behavior: no request or response logging
        return executeDeleteRequest(endpoint, boardId, false, false);
    }
    
    public Response executeDeleteRequest(String endpoint, String boardId, boolean logRequest) {
        // Default response logging behavior: no response logging
        return executeDeleteRequest(endpoint, boardId, logRequest, false);
    }
}
