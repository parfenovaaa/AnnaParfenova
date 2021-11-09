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
    public void exerciseOneTest() {

        TestData testData = new TestData();
        //2. Assert Browser title
        IndexPage indexPage = new IndexPage(webDriver);
        String actualTitle = indexPage.getPageTitle();
        Assert.assertEquals(actualTitle, testData.title);
        //3. Perform login
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser();
        //4. Assert Username is loggined
        String actualUserName = loginMenu.getUserName();
        Assert.assertEquals(actualUserName, testData.userName);

        //5. Open through the header menu Service -> Different Elements Page
        ElementsPage elementsPage = indexPage.navigateToElementsPage();

        //6. Select checkboxes: Water,Wind
        Assert.assertTrue(elementsPage.selectWaterWindCheckBox());

        //7. Select radio: Selen
        Assert.assertTrue(elementsPage.selectSelenRadio());

        //8. Select in dropdown: Yellow
        Assert.assertTrue(elementsPage.selectYellowDropdown());

        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        String[] actualLogCheckBox = elementsPage.getLogCheckBox();
        Assert.assertEquals(actualLogCheckBox, testData.logCheckBoxData);

        // and value is corresponded to the status of Radio
        String[] actualLogRadio = elementsPage.getLogRadio();
        Assert.assertEquals(actualLogRadio, testData.logRadioData);

        // and value is corresponded to the status of Dropdown
        String[] actualLogDropdown = elementsPage.getLogDropdown();
        Assert.assertEquals(actualLogDropdown, testData.logDropdownData);
    }
}
