package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.TestData;
import com.epam.tc.hw3.components.ElementsPage;
import com.epam.tc.hw3.components.IndexPage;
import com.epam.tc.hw3.components.LoginMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    @Test
    public void exerciseTwoTest() {

        //2. Assert Browser title
        IndexPage indexPage = new IndexPage(webDriver);
        String actualTitle = indexPage.getPageTitle();
        Assert.assertEquals(actualTitle, TestData.title);
        //3. Perform login
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser();
        //4. Assert Username is loggined
        String actualUserName = loginMenu.getUserName();
        Assert.assertEquals(actualUserName, TestData.userName);

        //5. Open through the header menu Service -> Different Elements Page
        ElementsPage elementsPage = indexPage.navigateToElementsPage();

        //6. Select checkboxes: Water,Wind
        elementsPage.clickOn("Wind", 1);
        elementsPage.clickOn("Water", 1);
        Assert.assertTrue(elementsPage.selectedWebElement("Wind"));
        Assert.assertTrue(elementsPage.selectedWebElement("Water"));

        //7. Select radio: Selen
        elementsPage.clickOn("Selen", 1);
        Assert.assertTrue(elementsPage.selectedWebElement("Wind"));

        //8. Select in dropdown: Yellow
        webDriver.navigate().to(webDriver.getCurrentUrl());
        elementsPage.selectDropdownByVisibleText("Yellow");
        Assert.assertEquals(elementsPage.getLog(), TestData.dropdownYellow);

        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        webDriver.navigate().to(webDriver.getCurrentUrl());
        elementsPage.clickOn("Water", 2);
        elementsPage.clickOn("Wind", 2);
        elementsPage.clickOn("Earth", 2);
        elementsPage.clickOn("Fire", 2);
        String[] actualLogCheckBox = elementsPage.getLog();
        Assert.assertEquals(actualLogCheckBox, TestData.logCheckBoxData);

        // and value is corresponded to the status of Radio
        webDriver.navigate().to(webDriver.getCurrentUrl());
        elementsPage.clickOn("Silver", 1);
        elementsPage.clickOn("Gold", 1);
        elementsPage.clickOn("Bronze", 1);
        elementsPage.clickOn("Selen", 1);
        String[] actualLogRadio = elementsPage.getLog();
        Assert.assertEquals(actualLogRadio, TestData.logRadioData);

        // and value is corresponded to the status of Dropdown
        webDriver.navigate().to(webDriver.getCurrentUrl());
        elementsPage.selectDropdownByVisibleText("Green");
        elementsPage.selectDropdownByVisibleText("Yellow");
        elementsPage.selectDropdownByVisibleText("Red");
        elementsPage.selectDropdownByVisibleText("Blue");
        String[] actualLogDropdown = elementsPage.getLog();
        Assert.assertEquals(actualLogDropdown, TestData.logDropdownData);
    }
}
