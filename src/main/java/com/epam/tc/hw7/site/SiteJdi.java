package com.epam.tc.hw7.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7.site.pages.HomePage;
import com.epam.tc.hw7.site.pages.MetalsColoursPage;
import com.epam.tc.hw7.site.section.LoginForm;
import org.openqa.selenium.WebElement;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {

    public static HomePage homePage;
    public static LoginForm loginForm;
    public static MetalsColoursPage metalsColoursPage;
    public static WebPage webPage;

    @Css(".profile-photo [ui=label]") public static UIElement userName;

    @Css(".logout") public static WebElement logout;
    @Css("img#user-icon") public static UIElement userIcon;
    @Css("ul.m-l8") public static Menu topMenu;
}
