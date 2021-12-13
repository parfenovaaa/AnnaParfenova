package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Random;

public class BoardSteps {

    @Step("Creating new board")
    public static Response createBoard() {
        String boardName = randomString();
        return requestBuilder()
                .setName(boardName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest();
    }

    @Step("Get board")
    public static Response getBoard(String boardId) {

        return requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(boardId);

    }

    @Step("Delete board")
    public static Response deleteBoard(String boardId) {

        return requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(boardId);

    }

    public static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
