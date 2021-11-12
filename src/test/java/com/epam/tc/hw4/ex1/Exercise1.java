package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.BaseTest;
import com.epam.tc.hw4.GetProperties;
import com.epam.tc.hw4.TestData;
import com.epam.tc.hw4.TestListener;
import com.epam.tc.hw4.components.IndexPage;
import com.epam.tc.hw4.components.LoginMenu;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
public class Exercise1 extends BaseTest {

    @Test
    @Epic("Epam training")
    @Feature("Homework 4")
    @Story("Login fail test")
    public void loginFailTest() {
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser(" ", " ");
        String actualUserName = loginMenu.getUserName();
        Assert.assertEquals(actualUserName, TestData.userName);
    }

    @Test
    @Epic("Epam training")
    @Feature("Homework 4")
    @Story("Exercise 1")
    public void exerciseOneTest() {
        //2. Assert Browser title
        IndexPage indexPage = new IndexPage(webDriver);
        String actualTitle = indexPage.getPageTitle();
        Assert.assertEquals(actualTitle, TestData.title);

        //3. Perform login
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser(GetProperties.login, GetProperties.password);

        //4. Assert Username is loggined
        String actualUserName = loginMenu.getUserName();
        Assert.assertEquals(actualUserName, TestData.userName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] actualLeftMenu = indexPage.getLeftMenuText();
        Assert.assertEquals(actualLeftMenu, TestData.leftMenuData);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        Assert.assertTrue(indexPage.imagesDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] actualImgTexts = indexPage.getImagesText();
        Assert.assertEquals(actualImgTexts, TestData.imgTextsData);

        //8. Assert that there is the iframe with “Frame Button” exist
        Assert.assertTrue(indexPage.frameExist());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        Assert.assertTrue(indexPage.frameButtonExist());

        //10. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] actualTopMenu = indexPage.getTopMenuText();
        Assert.assertEquals(actualTopMenu, TestData.topMenuData);

    }


}
