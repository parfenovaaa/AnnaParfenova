package com.epam.tc.hw4.fail;

import com.epam.tc.hw4.BaseTest;
import com.epam.tc.hw4.TestData;
import com.epam.tc.hw4.TestListener;
import com.epam.tc.hw4.components.LoginMenu;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
public class FailTestClass extends BaseTest {

    @Test
    @Epic("Epam training")
    @Feature("Homework 4")
    @Story("Login fail test")
    public void loginFailTest() {
        LoginMenu loginMenu = new LoginMenu(BaseTest.webDriver);
        loginMenu.loginUser(" ", " ");
        String actualUserName = loginMenu.getUserName();
        Assert.assertEquals(actualUserName, TestData.userName);
    }

}

