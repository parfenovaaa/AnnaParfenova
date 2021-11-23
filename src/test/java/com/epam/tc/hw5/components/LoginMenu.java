package com.epam.tc.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMenu  {

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

    public void loginUser(String login, String password) {
        dropdownToggle.click();
        nameElement.sendKeys(login);
        passwordElement.sendKeys(password);
        loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }
}
