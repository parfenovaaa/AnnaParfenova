package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.testng.Assert;

public class ElementsPageStep extends AbstractBaseSteps {

    @And("4 {string} should contain following values in {string} section on Elements Page:")
    public void checkboxesShouldBeContainValuesOnElementsPage(String name, String rowName, List<String> arg) {
        Assert.assertTrue(elementsPage.webElementsDisplayed(name));
        Assert.assertEquals(elementsPage.getRowText(name), deleteFirstRaw(arg));
    }

    @And("1 dropdown should contain values in dropdown section on Elements Page:")
    public void dropdownShouldBeDisplayedOnElementsPage(List<String> arg) {
        Assert.assertTrue(elementsPage.dropdownIsDisplayed());
        Assert.assertEquals(elementsPage.getDropdownOptions(), deleteFirstRaw(arg));
    }

    @When("I click on {string} in {string} section on the Elements Page")
    public void clickOnCheckbox(String name, String rowName) {
        elementsPage.clickOn(name);
    }

    @Then("{string} should be displayed as selected in {string} section on the Elements Page")
    public void inputDisplayedAsSelected(String name, String rowName) {
        Assert.assertTrue(elementsPage.selectedWebElement(name));
    }

    @When("I click on value {string} in the droplist on the Elements page")
    public void clickOnValueInDropdown(String name) {
        elementsPage.selectDropdownByVisibleText(name);
    }

    @Then("Log screen should contain {string} lines:")
    public void logScreenShouldContain(String count, List<String> log) {
        Assert.assertEquals(logSectionOnPage.getSomeLineLog(Integer.parseInt(count)), deleteFirstRaw(log));
    }
}
