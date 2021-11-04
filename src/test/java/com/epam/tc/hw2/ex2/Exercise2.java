package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    List<String> logs = new ArrayList<>();

    @BeforeClass
    public void beforeClass() {
        //2. Assert Browser title
        webElement = webDriver.findElement(By.tagName("title"));
        Assert.assertEquals("Home Page", webDriver.getTitle());

        //3. Perform login
        //4. Assert User name in the left-top side of screen that user is loggined
        webDriver.findElement(By.className("dropdown-toggle")).isEnabled();

        webElement = webDriver.findElements(By.className("dropdown-toggle")).get(1);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webElement);

        webDriver.findElements(By.id(loginNameLocator)).get(0).sendKeys(loginNameTest);
        webDriver.findElements(By.id(loginPasswordLocator)).get(0).sendKeys(loginPasswordTest);
        webDriver.findElement(By.id(loginButtonLocator)).click();
        String actualUserName = webDriver.findElements(By.id(loggedNameLocator)).get(0).getText();

        Assert.assertEquals(actualUserName, userNameTest);
    }


    @Test
    public void elementsSiteTest() {

        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.xpath("//li[@class = 'dropdown']")).click();
        webDriver.findElement(By.xpath("//a[@href='different-elements.html']")).click();

        //6. Select checkboxes: Water,Wind
        webDriver.findElement(By.xpath("//label[contains(.,'Water')]")).click();
        webDriver.findElement(By.xpath("//label[contains(.,'Wind')]")).click();
        boolean actualCheckBoxState = webDriver.findElement(By.xpath("//label[contains(.,'Water')]")).isEnabled()
            &&
            webDriver.findElement(By.xpath("//label[contains(.,'Wind')]")).isEnabled();
        Assert.assertTrue(actualCheckBoxState);

        //7. Select radio: Selen
        webDriver.findElement(By.xpath("//label[contains(.,'Selen')]")).click();
        Assert.assertTrue(webDriver.findElement(By.xpath("//label[contains(.,'Selen')]")).isEnabled());

        //8. Select in dropdown: Yellow

        Select dropdown = new Select(webDriver.findElements(By.className("uui-form-element")).get(2));
        dropdown.selectByVisibleText("Yellow");


        //9. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        webDriver.navigate().refresh();

        webDriver.findElement(By.xpath("//label[contains(.,'Water')]")).click();
        logs.add(" Water: condition changed to true\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Wind')]")).click();
        logs.add(" Wind: condition changed to true\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Earth')]")).click();
        logs.add(" Earth: condition changed to true\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Fire')]")).click();
        logs.add(" Fire: condition changed to true\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Water')]")).click();
        logs.add(" Water: condition changed to false\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Wind')]")).click();
        logs.add(" Wind: condition changed to false\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Earth')]")).click();
        logs.add(" Earth: condition changed to false\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Fire')]")).click();
        logs.add(" Fire: condition changed to false\n");

        String actualCheckBox = webDriver.findElements(By.className("panel-body-list")).get(0).getText();
        actualCheckBox = actualCheckBox.replaceAll("\\b[0-2]?\\d:[0-5]\\d\\b:[0-5]\\d\\b", "");

        logs = Lists.reverse(logs);
        String expected = String.join("", logs);
        logs.clear();
        expected = expected.substring(0, expected.length() - 1);
        Assert.assertEquals(actualCheckBox, expected);

        //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
        webDriver.navigate().refresh();
        logs.clear();

        webDriver.findElement(By.xpath("//label[contains(.,'Gold')]")).click();
        logs.add(" metal: value changed to Gold\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Silver')]")).click();
        logs.add(" metal: value changed to Silver\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Bronze')]")).click();
        logs.add(" metal: value changed to Bronze\n");

        webDriver.findElement(By.xpath("//label[contains(.,'Selen')]")).click();
        logs.add(" metal: value changed to Selen\n");

        String actualMetal = webDriver.findElements(By.className("panel-body-list")).get(0).getText();
        actualMetal = actualMetal.replaceAll("\\b[0-2]?\\d:[0-5]\\d\\b:[0-5]\\d\\b", "");

        logs = Lists.reverse(logs);
        String expectedMetal = String.join("", logs);
        logs.clear();
        expectedMetal = expectedMetal.substring(0, expectedMetal.length() - 1);
        Assert.assertEquals(actualMetal, expectedMetal);

        //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        webDriver.navigate().refresh();
        logs.clear();

        dropdown = new Select(webDriver.findElements(By.className("uui-form-element")).get(2));
        dropdown.selectByVisibleText("Green");
        logs.add(" Colors: value changed to Green\n");

        dropdown.selectByVisibleText("Yellow");
        logs.add(" Colors: value changed to Yellow\n");

        dropdown.selectByVisibleText("Red");
        logs.add(" Colors: value changed to Red\n");

        dropdown.selectByVisibleText("Blue");
        logs.add(" Colors: value changed to Blue\n");

        String actualDrop = webDriver.findElements(By.className("panel-body-list")).get(0).getText();
        actualDrop = actualDrop.replaceAll("\\b[0-2]?\\d:[0-5]\\d\\b:[0-5]\\d\\b", "");

        logs = Lists.reverse(logs);
        String expectedDrop = String.join("", logs);
        logs.clear();
        expectedDrop = expectedDrop.substring(0, expectedDrop.length() - 1);
        Assert.assertEquals(actualDrop, expectedDrop);
    }

}
