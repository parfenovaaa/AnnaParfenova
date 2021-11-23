package com.epam.tc.hw5.components;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogSectionOnPage {

    @FindBy(className = "panel-body-list")
    private  WebElement logScreen;

    String hourRegExp = "\\b[0-2]?\\d:[0-5]\\d\\b:[0-5]\\d\\b ";


    public LogSectionOnPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public  String getFirstLog() {
        return List.of(logScreen.getText()
                                .replaceAll(hourRegExp, "")
                                .split("\n")).get(0);
    }

    public  List<String> getSomeLineLog(int count) {
        List<String> log = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            log.add(List.of(logScreen.getText()
                                     .replaceAll(hourRegExp, "")
                                     .split("\n"))
                        .get(i));
        }
        return log;
    }

}
