package com.epam.tc.hw9.steps;

import static com.epam.tc.hw9.core.BoardServiceObject.getBoardData;
import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecOk;

import com.epam.tc.hw9.board.Board;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import java.util.Random;

public class BoardSteps {

    @Step("Creating new board")
    public static Board createBoard() {
        String boardName = randomString();
        return getBoardData(requestBuilder()
                .setName(boardName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest());
    }

    @Step("Get board")
    public static Board getBoard(String boardId) {

        return getBoardData(requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(boardId));

    }

    @Step("Delete board")
    public static void deleteBoard(String boardId) {

        requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(boardId).then().spec(responseSpecOk());
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
