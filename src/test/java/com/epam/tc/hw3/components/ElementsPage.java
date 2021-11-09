package com.epam.tc.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElementsPage {

    WebDriver webDriver;

    //CheckBox Select
    @FindBy(xpath = "//label[contains(., 'Water')]/input")
    WebElement waterCheckBox;

    @FindBy(xpath = "//label[contains(., 'Wind')]/input")
    WebElement windCheckBox;

    @FindBy(xpath = "//label[contains(., 'Earth')]/input")
    WebElement earthCheckBox;

    @FindBy(xpath = "//label[contains(., 'Fire')]/input")
    WebElement fireCheckBox;

    //Radio Select
    @FindBy(xpath = "//label[contains(., 'Silver')]/input")
    WebElement silverRadio;

    @FindBy(xpath = "//label[contains(., 'Gold')]/input")
    WebElement goldRadio;
    @FindBy(xpath = "//label[contains(., 'Bronze')]/input")
    WebElement bronzeRadio;

    @FindBy(xpath = "//label[contains(., 'Selen')]/input")
    WebElement selenRadio;

    //Log
    @FindBy(className = "panel-body-list")
    WebElement logScreen;

    //Dropdown Select
    @FindBy(css = "select.uui-form-element")
    WebElement select;

    Select dropdown;

    String hourRegExp = "\\b[0-2]?\\d:[0-5]\\d\\b:[0-5]\\d\\b ";

    public ElementsPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean selectWaterWindCheckBox() {
        waterCheckBox.click();
        windCheckBox.click();
        return (waterCheckBox.isSelected() && windCheckBox.isSelected());
    }

    public boolean selectSelenRadio() {
        selenRadio.click();

        return selenRadio.isSelected();
    }

    public boolean selectYellowDropdown() {
        webDriver.navigate().to(webDriver.getCurrentUrl());
        dropdown = new Select(select);
        dropdown.selectByVisibleText("Yellow");
        return logScreen.getText().replaceAll(hourRegExp, "")
                          .equals("Colors: value changed to Yellow");
    }


    public String[] getLogCheckBox() {
        webDriver.navigate().to(webDriver.getCurrentUrl());
        waterCheckBox.click();
        windCheckBox.click();
        earthCheckBox.click();
        fireCheckBox.click();

        waterCheckBox.click();
        windCheckBox.click();
        earthCheckBox.click();
        fireCheckBox.click();

        return logScreen.getText()
                  .replaceAll(hourRegExp, "")
                  .split("\n");
    }

    public String[] getLogRadio() {
        webDriver.navigate().to(webDriver.getCurrentUrl());
        silverRadio.click();
        goldRadio.click();
        bronzeRadio.click();
        selenRadio.click();

        return logScreen.getText()
                  .replaceAll(hourRegExp, "")
                  .split("\n");
    }

    public String[] getLogDropdown() {
        webDriver.navigate().to(webDriver.getCurrentUrl());
        dropdown = new Select(select);
        dropdown.selectByVisibleText("Green");
        dropdown.selectByVisibleText("Yellow");
        dropdown.selectByVisibleText("Red");
        dropdown.selectByVisibleText("Blue");

        return logScreen.getText()
                  .replaceAll(hourRegExp, "")
                  .split("\n");
    }

}
