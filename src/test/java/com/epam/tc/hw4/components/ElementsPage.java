package com.epam.tc.hw4.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElementsPage {

    //CheckBox Select
    @FindBy(xpath = "//label[contains(., 'Water')]/input")
    private WebElement waterCheckBox;

    @FindBy(xpath = "//label[contains(., 'Wind')]/input")
    private WebElement windCheckBox;

    @FindBy(xpath = "//label[contains(., 'Earth')]/input")
    private WebElement earthCheckBox;

    @FindBy(xpath = "//label[contains(., 'Fire')]/input")
    private WebElement fireCheckBox;

    //Radio Select
    @FindBy(xpath = "//label[contains(., 'Silver')]/input")
    private WebElement silverRadio;

    @FindBy(xpath = "//label[contains(., 'Gold')]/input")
    private WebElement goldRadio;
    @FindBy(xpath = "//label[contains(., 'Bronze')]/input")
    private WebElement bronzeRadio;

    @FindBy(xpath = "//label[contains(., 'Selen')]/input")
    private WebElement selenRadio;

    //Log
    @FindBy(className = "panel-body-list")
    private WebElement logScreen;

    //Dropdown Select
    @FindBy(css = "select.uui-form-element")
    private WebElement select;

    private Select dropdown;

    String hourRegExp = "\\b[0-2]?\\d:[0-5]\\d\\b:[0-5]\\d\\b";

    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Select in dropdown {colour}.")
    public void selectDropdownByVisibleText(String colour) {
        dropdown = new Select(select);
        dropdown.selectByVisibleText(colour);
    }

    @Step("Get log.")
    public String[] getLog() {
        return logScreen.getText()
                        .replaceAll(hourRegExp, "")
                        .split("\n");
    }

    @Step("Click on element {name} {count} times.")
    public void clickOn(String name, int count) {
        WebElement webElement = getWebElementByName(name);
        for (int i = 0; i < count; i++) {
            webElement.click();
        }
    }

    @Step("Selected element {name}.")
    public boolean selectedWebElement(String name) {
        WebElement webElement = getWebElementByName(name);
        return webElement.isSelected();
    }

    private WebElement getWebElementByName(String name) throws IllegalArgumentException {
        WebElement webElement;
        switch (name) {
            case  ("Wind"):
                webElement = windCheckBox;
                break;
            case  ("Water"):
                webElement = waterCheckBox;
                break;
            case  ("Fire"):
                webElement = fireCheckBox;
                break;
            case  ("Earth"):
                webElement = earthCheckBox;
                break;
            case  ("Silver"):
                webElement = silverRadio;
                break;
            case  ("Gold"):
                webElement = goldRadio;
                break;
            case  ("Bronze"):
                webElement = bronzeRadio;
                break;
            case  ("Selen"):
                webElement = selenRadio;
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
        return webElement;
    }

}
