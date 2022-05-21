package com.stormnet.refactored;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.stormnet.pages.MainPage;
import com.stormnet.pages.PrintedSummerDressPage;
import com.stormnet.pages.SummerDressesProductGridPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DisplaySummerDressWithDifferentColors extends BaseTest {

    @Test
    public void showSummerDressWithDifferentColors() {
        MainPage mainPage = Selenide.open(BASE_URL, MainPage.class);
        Assertions.assertTrue(mainPage.isPageOpened(),"Main page was not opened!");
        mainPage.hoverOverDressesButton();
        SummerDressesProductGridPage summerDressesProductGrid = mainPage.clickSummerDressesButton();
        Assertions.assertTrue(summerDressesProductGrid.isPageOpened(), "Catalog page with summer dresses hasn't opened!");
        summerDressesProductGrid.hoverOverPrintedSummerDress();
        PrintedSummerDressPage printedSummerDressPage = summerDressesProductGrid.clickMoreButton();
        Assertions.assertTrue(printedSummerDressPage.isPageOpened(), "Page with printed summer dress hasn't opened!");
        printedSummerDressPage.selectBlackColor();
        String Url_black = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertTrue(Url_black.contains("color-black"), "Color is not black!");
        printedSummerDressPage.selectOrangeColor();
        String Url_orange = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertTrue(Url_orange.contains("color-orange"), "Color is not orange!");
        printedSummerDressPage.selectBlueColor();
        String Url_blue = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertTrue(Url_blue.contains("color-blue"), "Color is not blue!");
        printedSummerDressPage.selectYellowColor();
        String Url_yellow = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertTrue(Url_yellow.contains("color-yellow"));
    }
}
