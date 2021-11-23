package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.GetProperties;
import com.epam.tc.hw5.components.ElementsPage;
import com.epam.tc.hw5.components.IndexPage;
import com.epam.tc.hw5.components.LogSectionOnPage;
import com.epam.tc.hw5.components.LoginMenu;
import com.epam.tc.hw5.components.UserTablePage;
import com.epam.tc.hw5.cucumber.hooks.CucumberHooks;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseSteps {

    protected IndexPage indexPage;
    protected LoginMenu loginMenu;
    protected ElementsPage elementsPage;
    protected UserTablePage userTablePage;
    protected LogSectionOnPage logSectionOnPage;

    public final WebDriver webDriver = CucumberHooks.webDriver;

    public AbstractBaseSteps() {

        indexPage = new IndexPage(webDriver);
        loginMenu = new LoginMenu(webDriver);
        elementsPage = new ElementsPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
        logSectionOnPage = new LogSectionOnPage(webDriver);
    }

    public void openIndexPage() throws IOException {
        GetProperties.getProp();
        CucumberHooks.webDriver.navigate().to(GetProperties.indexAddress);
    }

    public List<String> deleteFirstRaw(List<String> list) {
        List<String> listWithoutFirstRaw = new LinkedList<>(list);
        listWithoutFirstRaw.remove(0);
        return listWithoutFirstRaw;
    }
}
