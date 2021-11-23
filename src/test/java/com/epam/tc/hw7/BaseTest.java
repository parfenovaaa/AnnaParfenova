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
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(new LoginUserData());
        homePage.checkOpened();
    }

    @Test
    public void metalsColoursPageTest() throws IOException, ParseException {
        shouldBeLoggedIn();
        topMenu.select(MetalsColors);
        metalsColoursPage.shouldBeOpened();
        for (int i = 1; i < 6; i++) {
            MetalsColoursData testData = readJsonToMetalsColoursData(i);
            enterTestDataOnMetalsColorsPage(testData);
            String regex = "[\\p{Ps}\\p{Pe}]";
            String expected = testData.getDataInLine().replaceAll(regex, "");
            assertData(getResultTextData(), expected);
            WebPage.refresh();
        }
    }

    @Step("Assert data.")

    public void assertData(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public MetalsColoursData  readJsonToMetalsColoursData(int j) throws IOException, ParseException {

        String fileName = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(fileName));

        JSONObject data = (JSONObject) jsonObject.get("data_" + j);

        JSONArray summaryArray = (JSONArray) data.get("summary");
        long[] summary = new long[summaryArray.size()];
        for (int i = 0; i < summary.length; i++) {
            summary[i] = (long) summaryArray.get(i);
        }
        JSONArray elementsArray = (JSONArray) data.get("elements");
        String[] elements = new String[elementsArray.size()];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (String) elementsArray.get(i);
        }
        JSONArray vegetablesArray = (JSONArray) data.get("vegetables");
        String[] vegetables = new String[vegetablesArray.size()];
        for (int i = 0; i < vegetables.length; i++) {
            vegetables[i] = (String) vegetablesArray.get(i);
        }
        String color = (String) data.get("color");
        String metal = (String) data.get("metals");

        MetalsColoursData metalsColoursData = new MetalsColoursData();

        return metalsColoursData.set(summary, elements, color, metal, vegetables);
    }

    public String getResultTextData() {
        return resultText.getText();
    }

    public void enterTestDataOnMetalsColorsPage(MetalsColoursData testData) {

        long[] summery = testData.summary;
        for (long element : summery) {
            if (element % 2 == 0) {
                if (evenRadioButtons.selected(String.valueOf(element))) {
                    continue;
                } else {
                    evenRadioButtons.select(String.valueOf(element));
                }
            } else {
                if (oddRadioButtons.selected(String.valueOf(element))) {
                    continue;
                } else {
                    oddRadioButtons.select(String.valueOf(element));
                }
            }
        }

        String[] elements = testData.elements;
        for (String element : elements) {
            elementsCheckList.select(element);
        }

        String color = testData.color;
        colourDropdown.expand();
        colourDropdown.setValue(color);

        String[] vegetables = testData.vegetables;
        vegetablesDropdown.expand();
        vegetablesDropdown.setValue("vegetables");

        for (String element : vegetables) {
            vegetablesDropdown.setValue(element);
        }

        String metal = testData.metal;
        metalsDropdown.expand();
        metalsDropdown.setValue(metal);

        submitButton.click();
    }
}
