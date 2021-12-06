package com.epam.tc.hw9;

import static com.epam.tc.hw9.core.TrelloServiceObject.getBoardData;
import static com.epam.tc.hw9.core.TrelloServiceObject.getTheDeleteAnswer;
import static com.epam.tc.hw9.core.TrelloServiceObject.requestBuilder;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecError;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecOk;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.beans.DeletedBoard;
import io.restassured.http.Method;
import java.io.IOException;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BoardApiTest {

    private String consumerKey;
    private String accessToken;

    private final String request = "/1/boards/";

    @BeforeSuite
    public void setUp() {
        try {
            consumerKey = GetSetData.getKey();
            accessToken = GetSetData.getToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String boardId;

    @Test(priority = 1)
    public void createBoardTest() {

        String name = RandomStringUtils.random(10);

        Board board = getBoardData(
            requestBuilder()
                .setKey(consumerKey)
                .setToken(accessToken)
                .setName(name)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest(request)
        );

        assertThat(board.getName(), is(equalTo(name)));

        boardId = board.getId();
    }

    String newBoardName = "We changed board name";
    String newBoardDesc = "And added some desc";
    String newBoardColour = "pink";

    @Test(priority = 2)
    public void updateBoardNameTest() {

        requestBuilder()
            .setKey(consumerKey)
            .setToken(accessToken)
            .setName(newBoardName)
            .setDesc(newBoardDesc)
            .setColour(newBoardColour)
            .setMethod(Method.PUT)
            .buildRequest()
            .sendRequest(request + boardId)
            .then().assertThat().spec(responseSpecOk());

    }

    @Test(priority = 3)
    public void getExistBoardTest() {

        Board board = getBoardData(
            requestBuilder()
                .setKey(consumerKey)
                .setToken(accessToken)
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(request + boardId));


        assertThat(board.getName(), is(equalTo(newBoardName)));
        assertThat(board.getDesc(), is(equalTo(newBoardDesc)));
        assertThat(board.getPrefs().background, is(equalTo(newBoardColour)));

    }

    @Test(priority = 4)
    public void deleteBoardTest() {

        DeletedBoard board = getTheDeleteAnswer(
            requestBuilder()
                .setKey(consumerKey)
                .setToken(accessToken)
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(request + boardId));

        assertThat(board.get_value(), nullValue());
    }

    @Test(priority = 5)
    public void getDeletedBoardTest() {

        requestBuilder()
            .setKey(consumerKey)
            .setToken(accessToken)
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest(request + boardId)
            .then()
            .assertThat()
            .spec(responseSpecError())
            .and()
            .body(containsString("The requested resource was not found."));
    }
}
