package com.epam.tc.hw5.components;

import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserTablePage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxesList;
    @FindBy(xpath = "//tr/td/select")
    private List<WebElement> dropdownList;
    @FindBy(xpath = "//tr/td/a")
    private List<WebElement> namesList;
    @FindBy(xpath = "//td/div[@class='user-descr']")
    private List<WebElement> descriptionList;

    @FindBy(xpath = "//tbody/tr/td")
    public static List<WebElement> tableData;

    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public List<String> droplistContain() {
        WebElement droplist = dropdownList.get(0);
        Select select = new Select(droplist);
        List<String> list = new LinkedList<>();
        for (WebElement webElement : select.getOptions()) {
            list.add(webElement.getText());
        }
        return list;
    }

    public boolean sixElementsExist(String name) {
        List<WebElement> list = getWebElementByName(name);
        return (list.size() == 6);
    }

    public List<List<String>> getTableData() {
        List<List<String>> table = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < (tableData.size() / 4); i++) {
            List<String> rows = new LinkedList<>();
            rows.add(tableData.get(j).getText()); // get number
            rows.add(tableData.get(j + 2).getText()); // get name
            rows.add(tableData.get(j + 3)
                              .getText()
                              .replace("Vip", "")
                              .replaceAll("\n", " ")
                              .trim()); // get desc
            j = j + 4;
            table.add(rows);
        }
        return table;
    }

    public void clickOnWebElement(String name) {
        switch (name) {
            case ("Roman"):
                CucumberHooks.webDriver.findElement(By.id("roman")).click();
                break;
            case ("Sergey Ivan"):
                CucumberHooks.webDriver.findElement(By.id("ivan")).click();
                break;
            case ("Vladzimir"):
                CucumberHooks.webDriver.findElement(By.id("vlad")).click();
                break;
            case ("Helen Bennett"):
                CucumberHooks.webDriver.findElement(By.id("helen")).click();
                break;
            case ("Yoshi Tannamuri"):
                CucumberHooks.webDriver.findElement(By.id("yoshi")).click();
                break;
            case ("Giovanni Rovelli"):
                CucumberHooks.webDriver.findElement(By.id("gio")).click();
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
    }

    private List<WebElement> getWebElementByName(String name) throws IllegalArgumentException {
        List<WebElement> webElementList;
        switch (name) {
            case ("dropdown"):
                webElementList = dropdownList;
                break;
            case ("usernames"):
                webElementList = namesList;
                break;
            case ("descriptions"):
                webElementList = descriptionList;
                break;
            case ("checkboxes"):
                webElementList = checkboxesList;
                break;
            default:
                throw new IllegalArgumentException("No such element.");
        }
        return webElementList;
    }
}
