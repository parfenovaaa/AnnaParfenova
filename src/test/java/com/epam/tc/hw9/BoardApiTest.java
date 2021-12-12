package com.epam.tc.hw9;

import static com.epam.tc.hw9.beans.BoardBackgroundColour.randomColour;
import static com.epam.tc.hw9.core.BoardServiceObject.getBoardData;
import static com.epam.tc.hw9.core.BoardServiceObject.responseSpecError;
import static com.epam.tc.hw9.core.BoardServiceObject.responseSpecOk;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.steps.BoardSteps;
import io.restassured.response.Response;
import java.util.Random;
import org.testng.annotations.Test;

public class BoardApiTest {

    @Test
    public void createBoardTest() {

        String boardName = randomString();
        Response response = BoardSteps.createBoard(boardName);
        response.then().spec(responseSpecOk());

        Board board = getBoardData(response);
        assertThat(board.getName(), is(equalTo(boardName)));

        BoardSteps.deleteBoard(board.getId());
    }

    @Test
    public void updateBoardNameTest() {

        String boardName = randomString();
        Board testBoard = getBoardData(BoardSteps.createBoard(boardName));

        String newBoardName = randomString();
        String newBoardDesc = randomString();
        String newBoardColour = String.valueOf(randomColour());

        Response response = BoardSteps.updateBoardData(testBoard.getId(),
                newBoardName,
                newBoardDesc,
                newBoardColour);
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

        String boardName = randomString();
        Board testBoard = getBoardData(BoardSteps.createBoard(boardName));

        String newBoardName = randomString();
        String newBoardDesc = randomString();
        String newBoardColour = String.valueOf(randomColour());

        BoardSteps.updateBoardData(testBoard.getId(), newBoardName,
                newBoardDesc,
                newBoardColour);

        Response response = BoardSteps.getBoard(testBoard.getId());
        response.then()
                .assertThat().spec(responseSpecOk());
        Board board = getBoardData(response);
        assertThat(board.getName(), is(equalTo(newBoardName)));
        assertThat(board.getDesc(), is(equalTo(newBoardDesc)));
        assertThat(board.getPrefs().getBackground(), is(equalTo(newBoardColour)));

        BoardSteps.deleteBoard(board.getId());
    }

    @Test
    public void deleteBoardTest() {

        String boardName = randomString();
        Board testBoard = getBoardData(BoardSteps.createBoard(boardName));

        Response response = BoardSteps.deleteBoard(testBoard.getId());
        response.then()
                .assertThat().spec(responseSpecOk());

        assertThat(response.path("_value"), nullValue());
    }

    @Test
    public void getDeletedBoardTest() {

        String boardName = randomString();
        Board testBoard = getBoardData(BoardSteps.createBoard(boardName));
        BoardSteps.deleteBoard(testBoard.getId());

        Response response = BoardSteps.getBoard(testBoard.getId());
        response.then()
                .assertThat().spec(responseSpecError())
                .and()
                .body(containsString("The requested resource was not found."));
    }

    public String randomString() {
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
