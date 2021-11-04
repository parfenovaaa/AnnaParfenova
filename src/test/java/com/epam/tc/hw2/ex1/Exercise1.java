package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    //2. Assert Browser title
    @Test
    public void titleTest() {
        webElement = webDriver.findElement(By.tagName("title"));
        softAssert.assertEquals("Home Page", webDriver.getTitle());
    }

    //3. Perform login
    //4. Assert Username is loggined
    @Test
    public void loginTest() {

        webDriver.findElement(By.className("dropdown-toggle")).isEnabled();

        webElement = webDriver.findElements(By.className("dropdown-toggle")).get(1);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webElement);

        webDriver.findElements(By.id(loginNameLocator)).get(0).sendKeys(loginNameTest);
        webDriver.findElements(By.id(loginPasswordLocator)).get(0).sendKeys(loginPasswordTest);
        webDriver.findElement(By.id(loginButtonLocator)).click();
        String actualUserName = webDriver.findElements(By.id(loggedNameLocator)).get(0).getText();

        softAssert.assertEquals(actualUserName, userNameTest);
    }

    //5. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void headersTest() {

        String[] headers = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[@href = 'index.html']")).getText(), headers[0]);
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[@href = 'contacts.html']")).getText(), headers[1]);
        softAssert.assertEquals(webDriver.findElement(By.xpath("//li[@class = 'dropdown']")).getText(), headers[2]);
        softAssert.assertEquals(webDriver.findElement(By.xpath("//a[@href = 'metals-colors.html']")).getText(),
            headers[3]);
    }

    //6. Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void imgTest() {
        softAssert.assertTrue(
            webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-practise']")).isDisplayed());
        softAssert.assertTrue(
            webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-custom']")).isDisplayed());
        softAssert.assertTrue(
            webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-multi']")).isDisplayed());
        softAssert.assertTrue(
            webDriver.findElement(By.xpath("//span[@class='icons-benefit icon-base']")).isDisplayed());
    }

    //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void imgTextTest() {
        softAssert.assertEquals("To include good practices\nand ideas from successful\nEPAM project",
            webDriver.findElements(By.xpath("//span[@class='benefit-txt']")).get(0).getText());
        softAssert.assertEquals("To be flexible and\ncustomizable",
            webDriver.findElements(By.xpath("//span[@class='benefit-txt']")).get(1).getText());
        softAssert.assertEquals("To be multiplatform",
            webDriver.findElements(By.xpath("//span[@class='benefit-txt']")).get(2).getText());
        softAssert.assertEquals(
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…",
            webDriver.findElements(By.xpath("//span[@class='benefit-txt']")).get(3).getText());
    }

    //8. Assert that there is the iframe with “Frame Button” exist.
    //9. Switch to the iframe and check that there is “Frame Button” in the iframe
    //10. Switch to original window back
    @Test
    public void frameTest() {
        softAssert.assertEquals(webDriver.findElement(By.id("frame")).isDisplayed(), true);
        webElement = webDriver.findElement(By.id("frame"));
        webElement.isDisplayed();
        webDriver.switchTo().frame(webElement);
        softAssert.assertEquals(webDriver.findElement(By.id("frame-button")).isDisplayed(), true);
        webDriver.switchTo().defaultContent();
    }

    //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    @Test
    public void leftMenuTextTest() {

        String[] expected = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

        String menuText = webDriver.findElement(By.id("mCSB_1_container")).getText();
        String[] menuTexts = menuText.split("\n");
        for (int i = 0; i < menuTexts.length; i++) {
            softAssert.assertEquals(menuTexts[i], expected[i]);
        }
    }
}
