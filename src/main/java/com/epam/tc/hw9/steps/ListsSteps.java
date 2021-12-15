package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.core.ListsServiceObject.getListsData;
import static com.epam.tc.hw9.core.ListsServiceObject.requestBuilder;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecOk;

import com.epam.tc.hw9.lists.Lists;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import java.util.Random;

public class ListsSteps {

    @Step("Create new list")
    public static Lists createList(String idBoard) {
        String listName = randomString();
        return getListsData(requestBuilder()
                .setName(listName)
                .setIdBoard(idBoard)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest());
    }

    @Step("Get list")
    public static Lists getList(String listId) {

        return getListsData(requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(listId));

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
