package com.epam.tc.hw9.core;

import com.epam.tc.hw9.GetData;
import com.epam.tc.hw9.board.Board;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardServiceObject extends TrelloServiceObject {

    private static String consumerKey;
    private static String accessToken;

    public static final String request = "/1/boards/";

    private BoardServiceObject(Map<String, String> parameters, Method method) {
        super();
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        try {
            consumerKey = GetData.getKey();
            accessToken = GetData.getToken();
            URL = GetData.getURL() + request;
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

    public static Board getBoardData(Response response) {
        return response.as(Board.class);
    }


}
