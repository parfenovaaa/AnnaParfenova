package com.epam.tc.hw9;

import static com.epam.tc.hw9.core.BoardServiceObject.getBoardData;
import static com.epam.tc.hw9.core.ListsServiceObject.getListsData;
import static com.epam.tc.hw9.core.ListsServiceObject.requestBuilder;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecBadReq;
import static com.epam.tc.hw9.core.TrelloServiceObject.responseSpecOk;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.epam.tc.hw9.lists.Lists;
import com.epam.tc.hw9.steps.BoardSteps;
import com.epam.tc.hw9.steps.ListsSteps;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.util.Random;
import org.testng.annotations.Test;

public class ListsApiTest {

    @Test
    public void createListTest() {

        String testBoardId = getBoardData(BoardSteps.createBoard()).getId();

        String listName = randomString();
        Response response = requestBuilder()
                .setName(listName)
                .setIdBoard(testBoardId)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest();
        response.then().spec(responseSpecOk());

        Lists list = getListsData(response);
        assertThat(list.getName(), is(equalTo(listName)));

        BoardSteps.deleteBoard(testBoardId);
    }

    @Test
    public void createListWithoutBoardTest() {

        String listName = randomString();
        requestBuilder()
                .setName(listName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest()
                .then().spec(responseSpecBadReq());

    }

    @Test
    public void updateListNameTest() {

        String testBoardId = getBoardData(BoardSteps.createBoard()).getId();
        Lists list = getListsData(ListsSteps.createList(testBoardId));

        String newListName = randomString();

        Response response = requestBuilder()
                .setName(newListName)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest(list.getId());
        response.then()
                .assertThat().spec(responseSpecOk());
        Lists lists = getListsData(response);

        assertThat(lists.getName(), is(equalTo(newListName)));

        BoardSteps.deleteBoard(testBoardId);
    }

    @Test
    public void moveListTest() {

        String testBoardId = getBoardData(BoardSteps.createBoard()).getId();
        Lists list = getListsData(ListsSteps.createList(testBoardId));

        String newTestBoardId = getBoardData(BoardSteps.createBoard()).getId();

        requestBuilder()
                .setIdBoard(newTestBoardId)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest(list.getId());

        Response response = ListsSteps.getList(list.getId());
        response.then()
                .assertThat().spec(responseSpecOk());

        Lists lists = getListsData(response);

        assertThat(lists.getIdBoard(), is(equalTo(newTestBoardId)));

        BoardSteps.deleteBoard(testBoardId);
        BoardSteps.deleteBoard(newTestBoardId);
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
