package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.tc.hw7.ententies.TopMenuData.MetalsColors;
import static com.epam.tc.hw7.site.SiteJdi.homePage;
import static com.epam.tc.hw7.site.SiteJdi.loginForm;
import static com.epam.tc.hw7.site.SiteJdi.metalsColoursPage;
import static com.epam.tc.hw7.site.SiteJdi.topMenu;
import static com.epam.tc.hw7.site.SiteJdi.userIcon;
import static com.epam.tc.hw7.site.custom.MultiDropdown.colourDropdown;
import static com.epam.tc.hw7.site.custom.MultiDropdown.metalsDropdown;
import static com.epam.tc.hw7.site.custom.MultiDropdown.vegetablesDropdown;
import static com.epam.tc.hw7.site.pages.MetalsColoursPage.elementsCheckList;
import static com.epam.tc.hw7.site.pages.MetalsColoursPage.evenRadioButtons;
import static com.epam.tc.hw7.site.pages.MetalsColoursPage.oddRadioButtons;
import static com.epam.tc.hw7.site.pages.MetalsColoursPage.resultText;
import static com.epam.tc.hw7.site.pages.MetalsColoursPage.submitButton;
import static com.epam.tc.hw7.states.States.shouldBeLoggedIn;
import static com.epam.tc.hw7.states.States.shouldBeLoggedOut;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.ententies.LoginUserData;
import com.epam.tc.hw7.site.SiteJdi;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        initSite(SiteJdi.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        homePage.isOpened();
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(new LoginUserData());
        homePage.checkOpened();
    }

    @Test
    public void metalsColoursPageTest() {
        shouldBeLoggedIn();
        topMenu.select(MetalsColors);
        metalsColoursPage.shouldBeOpened();
        ReadTestDataFromJson dataFromJson = new ReadTestDataFromJson();
        for (int i = 1; i < 6; i++) {

            MetalsColoursData testData = dataFromJson.readJsonToMetalsColoursData(i);
            enterTestDataOnMetalsColorsPage(testData);

            String expected = testData.getDataInLine();
            assertData(getResultTextData(), expected);
            WebPage.refresh();
        }
    }

    @Step("Assert data.")
    public void assertData(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public String getResultTextData() {
        return resultText.getText();
    }

    public void enterTestDataOnMetalsColorsPage(MetalsColoursData testData) {

        String oddNumber = testData.odd;
        oddRadioButtons.select(oddNumber);

        String evenNumber = testData.even;
        evenRadioButtons.select(evenNumber);

        String[] elements = testData.elements;
        elementsCheckList.select(elements);

        String color = testData.color;
        colourDropdown.expand();
        colourDropdown.setValue(color);

        String[] vegetables = testData.vegetables;
        vegetablesDropdown.expand();
        vegetablesDropdown.setValue("vegetables");
        vegetablesDropdown.select(vegetables);

        String metal = testData.metal;
        metalsDropdown.expand();
        metalsDropdown.setValue(metal);

        submitButton.click();
    }
}
