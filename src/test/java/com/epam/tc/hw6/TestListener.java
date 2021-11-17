package com.epam.tc.hw6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {

        WebDriver webDriver = BaseTest.webDriver;
        String fileName;
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String filePath = "src/test/resources/fails/screenshots";
        new File(filePath);

        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("/dd-MM-yyyy_HH-mm-ss");
            fileName = filePath + formatter.format(date) + ".jpg";
            FileUtils.copyFile(scrFile, new File(fileName));
            try (InputStream is = new FileInputStream(fileName)) {
                AttachmentUtils.attachFromInputStream("Screenshot of fail.", is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
