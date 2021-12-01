package com.epam.tc.hw7.states;

import static com.epam.tc.hw7.site.SiteJdi.homePage;
import static com.epam.tc.hw7.site.SiteJdi.loginForm;
import static com.epam.tc.hw7.site.SiteJdi.logout;
import static com.epam.tc.hw7.site.SiteJdi.userIcon;
import static com.epam.tc.hw7.site.SiteJdi.userName;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.tc.hw7.ententies.LoginUserData;
import io.qameta.allure.Step;

public class States {

    private static void onSite() {
        if (!WebPage.getUrl().contains("https://jdi-testing.github.io/jdi-light/")) {
            homePage.open();
        }
    }

    @Step
    public static void shouldBeLoggedIn() {
        onSite();
        if (!userName.isDisplayed()) {
            login();
        }
    }

    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(new LoginUserData(), "enter");
    }

    @Step
    public static void shouldBeLoggedOut() {
        onSite();
        if (userName.isDisplayed()) {
            logout();
        }
        if (loginForm.isDisplayed()) {
            userIcon.click();
        }
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }
}
