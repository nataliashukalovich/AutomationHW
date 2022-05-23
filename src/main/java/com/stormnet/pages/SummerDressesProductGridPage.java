package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SummerDressesProductGridPage extends BasePage {

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement printedSummerDressTile = $x("(//*[@title='Printed Summer Dress' and @class='product_img_link'])[1]");
    private SelenideElement moreButton = $x("(//a[@title='View'])[1]");

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public SummerDressesProductGridPage hoverOverPrintedSummerDress() {
        printedSummerDressTile.shouldBe(Condition.visible).hover();
        return this;
    }

    public PrintedSummerDressPage clickMoreButton() {
        moreButton.shouldBe(Condition.visible).click();
        return new PrintedSummerDressPage();
    }
}
