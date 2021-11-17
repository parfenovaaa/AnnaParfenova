package com.epam.tc.hw4.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestListener;

public class LoginMenu implements ITestListener {

    @FindBy(xpath = "//li[@class='dropdown uui-profile-menu']")
    private WebElement dropdownToggle;
    @FindBy(id = "name")
    private WebElement nameElement;
    @FindBy(id = "password")
    private WebElement passwordElement;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;

    public LoginMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Login on page under name: {login}, password: {password}.")
    public void loginUser(String login, String password) {
        dropdownToggle.click();
        nameElement.sendKeys(login);
        passwordElement.sendKeys(password);
        loginButton.click();

        Assert.assertFalse(userName.getText().isEmpty());
    }

    @Step("Get logged user name.")
    public String getUserName() {
        return userName.getText();
    }
}
