package com.epam.tc.hw9.core;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.beans.DeletedBoard;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;
import java.util.Map;

public class TrelloServiceObject {

    public static final String URL = "https://api.trello.com";
    private final Method requestMethod;

    private final Map<String, String> parameters;

    private TrelloServiceObject(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
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

        public TrelloServiceObject buildRequest() {
            return new TrelloServiceObject(parameters, requestMethod);
        }
    }

    public Response sendRequest(String urlPart) {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, URL + urlPart)
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

    public static DeletedBoard getTheDeleteAnswer(Response response) {
        return response.as(DeletedBoard.class);
    }

    public static Board getBoardData(Response response) {
        return response.as(Board.class);
    }


}
