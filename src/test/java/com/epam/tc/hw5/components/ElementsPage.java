package com.epam.tc.hw5.components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkBoxRow;
    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radioRow;

    //Radio Select
    @FindBy(xpath = "//label[contains(., 'Silver')]/input")
    private WebElement silverRadio;
    @FindBy(xpath = "//label[contains(., 'Gold')]/input")
    private WebElement goldRadio;
    @FindBy(xpath = "//label[contains(., 'Bronze')]/input")
    private WebElement bronzeRadio;
    @FindBy(xpath = "//label[contains(., 'Selen')]/input")
    private WebElement selenRadio;

    //Dropdown Select
    @FindBy(css = "select.uui-form-element")
    private WebElement select;

    private Select dropdown;

    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean webElementsDisplayed(String name) {
        boolean exist = false;
        if (name.equals("checkboxes")) {
            exist = (waterCheckBox.isDisplayed()
                && earthCheckBox.isDisplayed()
                && windCheckBox.isDisplayed()
                && fireCheckBox.isDisplayed());
        } else if (name.equals("radio")) {
            exist = (goldRadio.isDisplayed()
                && silverRadio.isDisplayed()
                && bronzeRadio.isDisplayed()
                && selenRadio.isDisplayed());
        }
        return exist;
    }

    public boolean dropdownIsDisplayed() {
        return select.isDisplayed();
    }

    public List<String> getDropdownOptions() {
        dropdown = new Select(select);
        List<WebElement> actual = dropdown.getOptions();
        List<String> list = new LinkedList<>();
        for (WebElement webElement : actual) {
            list.add(webElement.getText());
        }
        return list;
    }

    public void clickOn(String name) {
        WebElement webElement = getWebElementByName(name);
        webElement.click();
    }

    public boolean selectedWebElement(String name) {
        WebElement webElement = getWebElementByName(name);
        return webElement.isSelected();
    }

    public void selectDropdownByVisibleText(String colour) {
        dropdown = new Select(select);
        dropdown.selectByVisibleText(colour);
    }

    public List<String> getRowText(String name) {
        List<String> list = new ArrayList<>();
        if (name.equals("checkboxes")) {
            List<WebElement> row = checkBoxRow;
            for (WebElement webElement : row) {
                list.add(webElement.getText());
            }
        } else if (name.equals("radio")) {
            List<WebElement> row = radioRow;
            for (WebElement webElement : row) {
                list.add(webElement.getText());
            }
        }
        return list;
    }

    private WebElement getWebElementByName(String name) throws IllegalArgumentException {
        WebElement webElement;
        switch (name) {
            case ("Wind"):
                webElement = windCheckBox;
                break;
            case ("Water"):
                webElement = waterCheckBox;
                break;
            case ("Fire"):
                webElement = fireCheckBox;
                break;
            case ("Earth"):
                webElement = earthCheckBox;
                break;
            case ("Silver"):
                webElement = silverRadio;
                break;
            case ("Gold"):
                webElement = goldRadio;
                break;
            case ("Bronze"):
                webElement = bronzeRadio;
                break;
            case ("Selen"):
                webElement = selenRadio;
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
        return webElement;
    }
}
