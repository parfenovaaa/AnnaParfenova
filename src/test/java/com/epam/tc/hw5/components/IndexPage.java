package com.epam.tc.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private final WebDriver driver;

    @FindBy(xpath = "//li[@class = 'dropdown']")
    private WebElement serviceButton;
    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement elementsPageButton;
    @FindBy(xpath = "//a[@href='user-table.html']")
    private WebElement userTablePageButton;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnServiceButton() {
        serviceButton.click();
    }

    public void navigateToElementsPage() {
        elementsPageButton.click();
        new ElementsPage(driver);
    }

    public void navigateToUserTablePage() {
        userTablePageButton.click();
        new UserTablePage(driver);
    }

}
