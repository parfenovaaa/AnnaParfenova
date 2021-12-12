package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class BoardSteps {

    @Step("Creating new board")
    public static Response createBoard(String boardName) {
        return requestBuilder()
                .setName(boardName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest();
    }

    @Step("Update board. Put new name, description, background colour.")
    public static Response updateBoardData(String boardId,
                                        String boardName,
                                        String boardDesc,
                                        String boardColour) {

        return requestBuilder()
                .setName(boardName)
                .setDesc(boardDesc)
                .setColour(boardColour)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest(boardId);

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


}
