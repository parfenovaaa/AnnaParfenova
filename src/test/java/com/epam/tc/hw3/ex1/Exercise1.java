package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.TestData;
import com.epam.tc.hw3.components.IndexPage;
import com.epam.tc.hw3.components.LoginMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    @Test
    public void exerciseOneTest() {
        TestData testData = new TestData();

        //2. Assert Browser title
        IndexPage indexPage = new IndexPage(webDriver);
        String actualTitle = indexPage.getPageTitle();
        Assert.assertEquals(actualTitle, testData.title);

        //3. Perform login
        LoginMenu loginMenu = new LoginMenu(webDriver);
        loginMenu.loginUser();

        //4. Assert Username is loggined
        String actualUserName = loginMenu.getUserName();
        Assert.assertEquals(actualUserName, testData.userName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] actualLeftMenu = indexPage.getLeftMenuText();
        Assert.assertEquals(actualLeftMenu, testData.leftMenuData);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        Assert.assertTrue(indexPage.imagesDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] actualImgTexts = indexPage.getImagesText();
        Assert.assertEquals(actualImgTexts, testData.imgTextsData);

        //8. Assert that there is the iframe with “Frame Button” exist
        Assert.assertTrue(indexPage.frameExist());
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        Assert.assertTrue(indexPage.frameButtonExist());

        //10. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] actualTopMenu = indexPage.getTopMenuText();
        Assert.assertEquals(actualTopMenu, testData.topMenuData);

    }
}
