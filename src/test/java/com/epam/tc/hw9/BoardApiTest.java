package com.epam.tc.hw9;

import static com.epam.tc.hw9.board.BoardBackgroundColour.randomColour;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardData;
import static com.epam.tc.hw9.core.BoardServiceObject.requestBuilder;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecError;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecOk;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import com.epam.tc.hw9.board.Board;
import com.epam.tc.hw9.steps.BoardSteps;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Random;
import org.testng.annotations.Test;

public class BoardApiTest {

    @Test
    public void createBoardTest() {

        String boardName = randomString();
        Response response = requestBuilder()
                .setName(boardName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest();
        response.then().spec(responseSpecOk());

        Board board = getBoardData(response);
        assertThat(board.getName(), is(equalTo(boardName)));

        BoardSteps.deleteBoard(board.getId());
    }

    @Test
    public void updateBoardNameTest() {

        Board testBoard = BoardSteps.createBoard();

        String newBoardName = randomString();
        String newBoardDesc = randomString();
        String newBoardColour = String.valueOf(randomColour());

        Response response = requestBuilder()
                .setName(newBoardName)
                .setDesc(newBoardDesc)
                .setColour(newBoardColour)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest(testBoard.getId());
        response.then()
                .assertThat().spec(responseSpecOk());
        Board board = getBoardData(response);

        assertThat(board.getName(), is(equalTo(newBoardName)));
        assertThat(board.getDesc(), is(equalTo(newBoardDesc)));
        assertThat(board.getPrefs().getBackground(), is(equalTo(newBoardColour)));

        BoardSteps.deleteBoard(board.getId());
    }

    @Test
    public void getExistBoardTest() {

        Board testBoard = BoardSteps.createBoard();

        String newBoardName = randomString();
        String newBoardDesc = randomString();
        String newBoardColour = String.valueOf(randomColour());

        requestBuilder()
                .setName(newBoardName)
                .setDesc(newBoardDesc)
                .setColour(newBoardColour)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest(testBoard.getId());

        Board board = BoardSteps.getBoard(testBoard.getId());

        assertThat(board.getName(), is(equalTo(newBoardName)));
        assertThat(board.getDesc(), is(equalTo(newBoardDesc)));
        assertThat(board.getPrefs().getBackground(), is(equalTo(newBoardColour)));

        BoardSteps.deleteBoard(board.getId());
    }

    @Test
    public void deleteBoardTest() {

        Board testBoard = BoardSteps.createBoard();

        Response response = requestBuilder()
                .setMethod(Method.DELETE)
                .buildRequest()
                .sendRequest(testBoard.getId());
        response.then()
                .assertThat().spec(responseSpecOk());

        assertThat(response.path("_value"), nullValue());
    }

    @Test
    public void getDeletedBoardTest() {

        Board testBoard = BoardSteps.createBoard();
        BoardSteps.deleteBoard(testBoard.getId());

        Response response = requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(testBoard.getId());
        response.then()
                .assertThat().spec(responseSpecError())
                .and()
                .body(containsString("The requested resource was not found."));
    }

    public String randomString() {
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
