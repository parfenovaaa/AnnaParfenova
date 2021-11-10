package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver webDriver;
    String address = "https://jdi-testing.github.io/jdi-light/index.html";

    //1. Open test site by URL
    @BeforeClass
    public void initializeWebDriver() throws IOException {
        GetProperties.getProp();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.navigate().to(GetProperties.address);
    }

    //12. Close Browser
    @AfterClass
    public void quitDriver() {
        webDriver.quit();
    }

}
