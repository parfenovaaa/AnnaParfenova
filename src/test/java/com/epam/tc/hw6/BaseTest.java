package com.epam.tc.hw6;

import com.epam.tc.hw6.service.WebDriverProvider;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver webDriver;

    //1. Open test site by URL
    @BeforeMethod
    public void initializeWebDriver() throws IOException, IllegalAccessException {
        GetProperties.getProp();
        webDriver = WebDriverProvider.getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.navigate().to(GetProperties.address);
    }

    //12. Close Browser
    @AfterMethod
    public void quitDriver() {
        WebDriverProvider.closeDriver();
    }

}
