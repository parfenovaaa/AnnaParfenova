package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.core.ListsServiceObject.requestBuilder;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Random;

public class ListsSteps {

    @Step("Create new list")
    public static Response createList(String idBoard) {
        String listName = randomString();
        return requestBuilder()
                .setName(listName)
                .setIdBoard(idBoard)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest();
    }

    @Step("Get list")
    public static Response getList(String listId) {

        return requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(listId);

    }

    public static String randomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
