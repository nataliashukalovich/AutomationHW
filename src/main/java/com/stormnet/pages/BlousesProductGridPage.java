package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BlousesProductGridPage extends BasePage {

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement blouseTile = $x("//a[@title='Blouse' and @class='product_img_link']");
    private SelenideElement moreButton = $x("(//a[@title='View'])[1]");

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public BlousesProductGridPage hoverOverBlouseTile() {
        blouseTile.shouldHave(Condition.visible).hover();
        return this;
    }

    public BlouseProductPage clickOnMoreButton() {
        moreButton.shouldHave(Condition.visible).click();
        return new BlouseProductPage();
    }
}
