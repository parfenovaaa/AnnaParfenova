package com.epam.tc.hw9.core;

import com.epam.tc.hw9.beans.Board;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardServiceObject {

    private static String URL;
    private static String consumerKey;
    private static String accessToken;

    public static final String request = "/1/boards/";

    private final Method requestMethod;
    private final Map<String, String> parameters;

    private BoardServiceObject(Map<String, String> parameters, Method method) {

        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        try {
            consumerKey = GetSetData.getKey();
            accessToken = GetSetData.getToken();
            URL = GetSetData.getURL() + request;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ApiRequestBuilder().setKey(consumerKey).setToken(accessToken);
    }

    public static class ApiRequestBuilder {
        private final Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setKey(String key) {
            parameters.put("key", key);
            return this;
        }

        public ApiRequestBuilder setToken(String token) {
            parameters.put("token", token);
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            parameters.put("name", name);
            return this;
        }

        public ApiRequestBuilder setId(String id) {
            parameters.put("id", id);
            return this;
        }

        public ApiRequestBuilder setDesc(String desc) {
            parameters.put("desc", desc);
            return this;
        }

        public ApiRequestBuilder setColour(String colour) {
            parameters.put("prefs/background", colour);
            return this;
        }

        public BoardServiceObject buildRequest() {
            return new BoardServiceObject(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, URL)
                .prettyPeek();
    }

    public Response sendRequest(String request) {
        return RestAssured
                .given(requestSpecification()).log().all()
                .queryParams(parameters)
                .request(requestMethod, URL + request)
                .prettyPeek();
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(URL)
                .build();
    }

    public static ResponseSpecification responseSpecOk() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecError() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.TEXT)
                .expectStatusCode(404)
                .build();
    }

    public static Board getBoardData(Response response) {
        return response.as(Board.class);
    }


}
