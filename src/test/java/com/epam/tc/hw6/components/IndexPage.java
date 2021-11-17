package com.epam.tc.hw6.components;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private final WebDriver driver;

    @FindBy(css = "div.mCSB_container")
    private List<WebElement> leftMenu;

    @FindBy(xpath = "//span[@class='icons-benefit icon-practise']")
    private WebElement img1;
    @FindBy(xpath = "//span[@class='icons-benefit icon-custom']")
    private WebElement img3;
    @FindBy(xpath = "//span[@class='icons-benefit icon-multi']")
    private WebElement img2;
    @FindBy(xpath = "//span[@class='icons-benefit icon-base']")
    private WebElement img4;
    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> imgtext;

    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(css = "ul.m-l8")
    private WebElement topMenu;
    @FindBy(xpath = "//li[@class = 'dropdown']")
    private WebElement serviceButton;
    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement elementsPageButton;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get page title.")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Get left menu texts.")
    public String[] getLeftMenuText() {
        String text = leftMenu.get(0).getText();
        return text.split("\n");
    }

    @Step("Displaying images on page.")
    public boolean imagesDisplayed() {
        return (img1.isDisplayed() && img2.isDisplayed() && img3.isDisplayed() && img4.isDisplayed());
    }

    @Step("Get texts under images.")
    public String[] getImagesText() {

        return new String[] {imgtext.get(0).getText(),
            imgtext.get(1).getText(),
            imgtext.get(2).getText(),
            imgtext.get(3).getText()};
    }

    @Step("Frame exist on page.")
    public boolean frameExist() {
        return frame.isDisplayed();
    }

    @Step("Button exist in frame on page.")
    public boolean frameButtonExist() {
        driver.switchTo().frame(frame);

        boolean button = frameButton.isDisplayed();
        driver.switchTo().defaultContent();
        return button;
    }

    @Step("Get top menu texts.")
    public String[] getTopMenuText() {
        String text = topMenu.getText();
        return text.split("\n");
    }

    @Step("Navigate from index page to elements page.")
    public ElementsPage navigateToElementsPage() {
        serviceButton.click();
        elementsPageButton.click();
        return new ElementsPage(driver);
    }
}
