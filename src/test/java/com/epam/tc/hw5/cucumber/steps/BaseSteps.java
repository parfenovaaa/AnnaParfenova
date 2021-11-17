package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.GetProperties;
import com.epam.tc.hw5.TestData;
import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.testng.Assert;

public class BaseSteps extends AbstractBaseSteps {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubSite() throws IOException {
        openIndexPage();
    }

    @And("I login as user \"Roman Iovlev\"")
    public void loginAsUser() {
        loginMenu.loginUser(GetProperties.login, GetProperties.password);
    }

    @Then("I logged as user on Index page")
    public void loggedAsRoman() {
        Assert.assertEquals(loginMenu.getUserName(), TestData.userName);
    }

    @When("I click on \"Service\" button in Header")
    public void clickServiceButton() {
        indexPage.clickOnServiceButton();
    }

    @And("I click on {string} button in Service dropdown")
    public void clickButtonInService(String pageName) {
        switch (pageName) {
            case ("Different Elements"):
                indexPage.navigateToElementsPage();
                break;
            case ("User Table"):
                indexPage.navigateToUserTablePage();
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
    }

    @Then("The {string} page should be opened")
    public void pageShouldBeOpen(String name) {
        switch (name) {
            case ("Elements Page"):
                Assert.assertEquals(CucumberHooks.webDriver.getCurrentUrl(), TestData.elementsPageURL);
                break;
            case ("User Table"):
                Assert.assertEquals(CucumberHooks.webDriver.getCurrentUrl(), TestData.userTablePageURL);
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
    }

    @Then("1 log row has {string} text in log section")
    public void logFirstRowContain(String line) {
        Assert.assertEquals(logSectionOnPage.getFirstLog(), line);
    }

}
