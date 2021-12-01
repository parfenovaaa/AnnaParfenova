package com.epam.tc.hw5.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHooks {

    public static WebDriver webDriver = null;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        if (webDriver == null) {
            webDriver  = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }


}
