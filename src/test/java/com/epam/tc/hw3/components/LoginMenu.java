package com.epam.tc.hw3.components;

import com.epam.tc.hw3.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMenu {

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

    public void loginUser()  {
        dropdownToggle.click();
        nameElement.sendKeys(GetProperties.login);
        passwordElement.sendKeys(GetProperties.password);
        loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

}
