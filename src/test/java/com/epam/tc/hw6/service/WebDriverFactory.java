package com.epam.tc.hw6.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class WebDriverFactory {

    private static final String LOCAL_LAUNCH = "local";
    private static final String REMOTE_LAUNCH = "remote";

    public static WebDriver createWebDriver(final String launchType, final Browser browser)
        throws IllegalAccessException {

        WebDriver webDriver;
        if (LOCAL_LAUNCH.equalsIgnoreCase(launchType)) {
            webDriver = createLocalWebDriver(browser);
        } else if (REMOTE_LAUNCH.equalsIgnoreCase(launchType)) {
            webDriver = createRemoteWebDriver(browser);
        } else {
            throw new IllegalAccessException("Unsupported launch type.");
        }
        return webDriver;
    }

    private static WebDriver createLocalWebDriver(final Browser browser) throws IllegalAccessException {
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                webDriver = createChromeDriver();
                break;
            case FIREFOX:
                webDriver = createFirefoxDriver();
                break;
            case EDGE:
                webDriver = createEdgeDriver();
                break;
            default:
                throw new IllegalAccessException("Unsupported launch type.");
        }
        return webDriver;
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createRemoteWebDriver(final Browser browser) throws IllegalAccessException {
        Capabilities capabilities;
        switch (browser) {
            case CHROME:
                capabilities = createChromeCapabilities();
                break;
            case FIREFOX:
                capabilities = createFirefoxCapabilities();
                break;
            case EDGE:
                capabilities = createEdgeCapabilities();
                break;
            default:
                throw new IllegalAccessException("Unsupported launch type.");
        }
        WebDriver webDriver;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalAccessException("Unsupported launch type." + e);
        }
        return webDriver;
    }

    private static Capabilities createChromeCapabilities() {
        return new ChromeOptions();
    }

    private static Capabilities createFirefoxCapabilities() {
        return new FirefoxOptions();
    }

    private static Capabilities createEdgeCapabilities() {
        return new EdgeOptions();
    }
}
