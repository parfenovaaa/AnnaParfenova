package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver webDriver;
    String address;

    //1. Open test site by URL
    @BeforeClass
    public void initializeWebDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getProp();
        webDriver.navigate().to(address);

    }

    //12. Close Browser
    @AfterClass
    public void quitDriver() {
        webDriver.quit();
    }

    public String title;
    public String userName;
    public String[] leftMenuData;
    public String[] topMenuData;
    public String[] imgTextsData;
    public String[] logCheckBoxData;
    public String[] logRadioData;
    public String[] logDropdownData;

    public void getProp() throws IOException {
        FileInputStream file;
        Properties property = new Properties();

        file = new FileInputStream("src/test/resources/config.properties");
        property.load(file);

        address = property.getProperty("test.address");

        title = property.getProperty("index.title");
        userName = property.getProperty("login.userName");

        leftMenuData = property.getProperty("index.leftMenu").split(",");
        topMenuData = property.getProperty("index.topMenu").split(",");
        imgTextsData = property.getProperty("index.texts").split("#");

        logCheckBoxData = property.getProperty("elements.logCheckBox").split(",");
        logRadioData = property.getProperty("elements.logRadio").split(",");
        logDropdownData = property.getProperty("elements.logDropdown").split(",");
    }
}
