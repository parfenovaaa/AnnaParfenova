package com.epam.tc.hw9.core;

import com.epam.tc.hw9.GetData;
import com.epam.tc.hw9.lists.Lists;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ListsServiceObject extends TrelloServiceObject {

    private static String consumerKey;
    private static String accessToken;

    public static final String request = "/1/lists/";

    private ListsServiceObject(Map<String, String> parameters, Method method) {
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

        public ApiRequestBuilder setIdBoard(String idBoard) {
            parameters.put("idBoard", idBoard);
            return this;
        }

        public ApiRequestBuilder setPos(String pos) {
            parameters.put("pos", pos);
            return this;
        }

        public ApiRequestBuilder setClosed(String closed) {
            parameters.put("closed", closed);
            return this;
        }

        public ApiRequestBuilder setValue(String value) {
            parameters.put("value", value);
            return this;
        }

        public ListsServiceObject buildRequest() {
            return new ListsServiceObject(parameters, requestMethod);
        }
    }

    public static Lists getListsData(Response response) {
        return response.as(Lists.class);
    }


}
