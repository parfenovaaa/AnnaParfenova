package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public static WebDriver webDriver;
    public WebElement webElement;

    public final SoftAssert softAssert = new SoftAssert();

    public final String loginNameTest = "Roman";
    public final String loginPasswordTest = "Jdi1234";
    public final String userNameTest = "ROMAN IOVLEV";

    public final String loginNameLocator = "name";
    public final String loginPasswordLocator = "password";
    public final String loginButtonLocator = "login-button";
    public final String loggedNameLocator = "user-name";

    private final String address = "https://jdi-testing.github.io/jdi-light/index.html";

    //1. Open test site by URL
    @BeforeClass
    public void initializeWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Open test site
        webDriver.navigate().to(address);
    }

    //12. Close Browser
    @AfterClass
    public void quitDriver() {
        softAssert.assertAll();
        webDriver.quit();
    }
}
