package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.components.IndexPage;
import com.epam.tc.hw3.components.LoginMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @DataProvider(name = "titleDataProvider")
    public Object[][] titleDataProvider() {
        return new Object[][] {
            {"Home Page"}};
    }

    @Test(dataProvider = "titleDataProvider")
    public void titleTest(String expected) {
        IndexPage indexPage = new IndexPage(webDriver);
        String actual = indexPage.getPageTitle();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "userNameDataProvider")
    public Object[][] userNameDataProvider() {
        return new Object[][] {
            {"ROMAN IOVLEV"}};
    }

    @Test(dataProvider = "userNameDataProvider")
    public void loginTest(String expected) {
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser();
        String actual = loginMenu.getUserName();
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "leftMenuDataProvider")
    public Object[][] leftMenuDataProvider() {
        return new Object[][] {
            {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"}};
    }

    @Test(dataProvider = "leftMenuDataProvider")
    public void leftMenuTest(String[] expected) {
        IndexPage indexPage = new IndexPage(webDriver);
        String[] actual = indexPage.getLeftMenuText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void imagesTest() {
        IndexPage indexPage = new IndexPage(webDriver);
        Assert.assertTrue(indexPage.imagesDisplayed());
    }

    @DataProvider(name = "imagesTextsDataProvider")
    public Object[][] imagesTextsProvider() {
        return new Object[][] {
            {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}};
    }

    @Test(dataProvider = "imagesTextsDataProvider")
    public void imagesTextsTest(String[] expected) {
        IndexPage indexPage = new IndexPage(webDriver);
        String[] actual = indexPage.getImagesText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void frameTest() {
        IndexPage indexPage = new IndexPage(webDriver);
        Assert.assertTrue(indexPage.frameExist());
    }

    @Test
    public void frameButtonTest() {
        IndexPage indexPage = new IndexPage(webDriver);
        Assert.assertTrue(indexPage.frameButtonExist());
    }

    @DataProvider(name = "topMenuDataProvider")
    public Object[][] topMenuDataProvider() {
        return new Object[][] {
            {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"}};
    }

    @Test(dataProvider = "topMenuDataProvider")
    public void topMenuTest(String[] expected) {
        IndexPage indexPage = new IndexPage(webDriver);
        String[] actual = indexPage.getTopMenuText();
        Assert.assertEquals(actual, expected);
    }

}
