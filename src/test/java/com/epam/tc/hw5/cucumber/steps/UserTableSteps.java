package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import java.util.LinkedList;
import java.util.List;
import org.testng.Assert;

public class UserTableSteps extends AbstractBaseSteps {

    @And("6 {string} should be displayed on Users Table on User Table Page")
    public void sixSomethingShouldBeDisplayed(String name) {
        switch (name) {
            case  ("Number Type Dropdowns"):
                Assert.assertTrue(userTablePage.sixElementsExist("dropdown"));
                break;
            case  ("Usernames"):
                Assert.assertTrue(userTablePage.sixElementsExist("usernames"));
                break;
            case  ("Description texts under images"):
                Assert.assertTrue(userTablePage.sixElementsExist("descriptions"));
                break;
            case  ("checkboxes"):
                Assert.assertTrue(userTablePage.sixElementsExist("checkboxes"));
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
    }

    @And("User table should contain following values:")
    public void userTableShouldContainValues(DataTable arg) {
        List<List<String>> table = new LinkedList<>(arg.asLists(String.class));

        table.remove(0);
        Assert.assertEquals(userTablePage.getTableData(), table);
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesForRoman(List<String> args) {
        Assert.assertEquals(userTablePage.droplistContain(), deleteFirstRaw(args));
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckboxForSergey(String name) {
        userTablePage.clickOnWebElement(name);
    }

}
