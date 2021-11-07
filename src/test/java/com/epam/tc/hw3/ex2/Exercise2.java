package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.components.ElementsPage;
import com.epam.tc.hw3.components.IndexPage;
import com.epam.tc.hw3.components.LoginMenu;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    @DataProvider(name = "titleDataProvider")
    public Object[][] titleDataProvider() {
        return new Object[][] {
            {"Home Page"}};
    }

    @Test(priority = 1, dataProvider = "titleDataProvider")
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

    @Test(priority = 2, dataProvider = "userNameDataProvider")
    public void loginTest(String expected) {
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser();
        String actual = loginMenu.getUserName();
        Assert.assertEquals(actual, expected);
    }

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void elementsSiteTest() {
        IndexPage indexPage = new IndexPage(webDriver);
        ElementsPage elementsPage = indexPage.navigateToElementsPage();

        //6. Select checkboxes: Water,Wind
        Assert.assertTrue(elementsPage.selectWaterWindCheckBox());

        //7. Select radio: Selen
        Assert.assertTrue(elementsPage.selectSelenRadio());

        //8. Select in dropdown: Yellow
        Assert.assertTrue(elementsPage.selectYellowDropdown());
    }

    @DataProvider(name = "logCheckBoxDataProvider")
    public Object[][] logCheckBoxDataProvider() {
        return new Object[][] {
            {" Fire: condition changed to false",
                " Earth: condition changed to false",
                " Wind: condition changed to false",
                " Water: condition changed to false",
                " Fire: condition changed to true",
                " Earth: condition changed to true",
                " Wind: condition changed to true",
                " Water: condition changed to true"}};
    }

    //9. Assert that for each checkbox there is an individual log row
    // and value is corresponded to the status of checkbox
    @Test(priority = 4, dataProvider = "logCheckBoxDataProvider")
    public void checkBoxLogTest(String[] expectedLogCheckBox) {

        webDriver.navigate().to(webDriver.getCurrentUrl());
        ElementsPage elementsPage = new ElementsPage(webDriver);
        String[] actualLogCheckBox = elementsPage.getLogCheckBox();
        Assert.assertEquals(actualLogCheckBox, expectedLogCheckBox);
    }

    @DataProvider(name = "logRadioDataProvider")
    public Object[][] logRadioDataProvider() {
        return new Object[][] {
            {" metal: value changed to Selen",
                " metal: value changed to Bronze",
                " metal: value changed to Gold",
                " metal: value changed to Silver"}};
    }

    @Test(priority = 5, dataProvider = "logRadioDataProvider")
    public void radioLogTest(String[] expectedLogRadio) {

        ElementsPage elementsPage = new ElementsPage(webDriver);
        webDriver.navigate().to(webDriver.getCurrentUrl());
        String[] actualLogCheckBox = elementsPage.getLogRadio();
        Assert.assertEquals(actualLogCheckBox, expectedLogRadio);
    }

    @DataProvider(name = "logDropdownDataProvider")
    public Object[][] logDropdownDataProvider() {
        return new Object[][] {
            {" Colors: value changed to Blue",
                " Colors: value changed to Red",
                " Colors: value changed to Yellow",
                " Colors: value changed to Green"}};
    }

    @Test(priority = 6, dataProvider = "logDropdownDataProvider")
    public void dropdownLogTest(String[] expectedLogDropdown) {
        ElementsPage elementsPage = new ElementsPage(webDriver);
        String[] actualLogCheckBox = elementsPage.getLogDropdown();
        Assert.assertEquals(actualLogCheckBox, expectedLogDropdown);
    }
}
