package com.epam.tc.hw3.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMenu {

    WebDriver webDriver;

    @FindBy(xpath = "//li[@class='dropdown uui-profile-menu']")
    WebElement dropdownToggle;
    @FindBy(id = "name")
    WebElement nameElement;
    @FindBy(id = "password")
    WebElement passwordElement;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(id = "user-name")
    WebElement userName;

    private String login;
    private String password;

    public LoginMenu(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getProp() throws IOException {
        FileInputStream file;
        Properties property = new Properties();

        file = new FileInputStream("src/test/resources/config.properties");
        property.load(file);

        login = property.getProperty("login.name");
        password = property.getProperty("login.password");
    }

    public void loginUser() {
        try {
            getProp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dropdownToggle.click();
        nameElement.sendKeys(login);
        passwordElement.sendKeys(password);
        loginButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }

}
