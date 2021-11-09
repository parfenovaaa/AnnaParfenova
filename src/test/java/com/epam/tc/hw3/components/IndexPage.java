package com.epam.tc.hw3.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    WebDriver driver;

    @FindBy(css = "div.mCSB_container")
    List<WebElement> leftMenu;

    @FindBy(xpath = "//span[@class='icons-benefit icon-practise']")
    WebElement img1;
    @FindBy(xpath = "//span[@class='icons-benefit icon-custom']")
    WebElement img3;
    @FindBy(xpath = "//span[@class='icons-benefit icon-multi']")
    WebElement img2;
    @FindBy(xpath = "//span[@class='icons-benefit icon-base']")
    WebElement img4;
    @FindBy(xpath = "//span[@class='benefit-txt']")
    List<WebElement> imgtext;

    @FindBy(id = "frame")
    WebElement frame;
    @FindBy(id = "frame-button")
    WebElement frameButton;

    @FindBy(css = "ul.m-l8")
    WebElement topMenu;
    @FindBy(xpath = "//li[@class = 'dropdown']")
    WebElement serviceButton;
    @FindBy(xpath = "//a[@href='different-elements.html']")
    WebElement elementsPageButton;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String[] getLeftMenuText() {
        String text = leftMenu.get(0).getText();
        return text.split("\n");
    }

    public boolean imagesDisplayed() {
        return (img1.isDisplayed() && img2.isDisplayed() && img3.isDisplayed() && img4.isDisplayed());
    }

    public String[] getImagesText() {

        return new String[] {imgtext.get(0).getText(),
            imgtext.get(1).getText(),
            imgtext.get(2).getText(),
            imgtext.get(3).getText()};
    }

    public boolean frameExist() {
        return frame.isDisplayed();
    }

    public boolean frameButtonExist() {
        driver.switchTo().frame(frame);

        boolean button = frameButton.isDisplayed();
        driver.switchTo().defaultContent();
        return button;
    }

    public String[] getTopMenuText() {
        String text = topMenu.getText();
        return text.split("\n");
    }

    public ElementsPage navigateToElementsPage() {
        serviceButton.click();
        elementsPageButton.click();
        return new ElementsPage(driver);
    }
}
