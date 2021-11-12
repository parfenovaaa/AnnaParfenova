package com.epam.tc.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver webDriver;

    //1. Open test site by URL
    @BeforeMethod
    public void initializeWebDriver() throws IOException {
        GetProperties.getProp();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.navigate().to(GetProperties.address);
    }

    //12. Close Browser
    @AfterMethod
    public void quitDriver() {
        webDriver.quit();
    }

}
