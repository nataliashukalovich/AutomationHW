package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TshirtsProductGridPage extends BasePage {

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement fadedTshirtTile = $x("//a[@title='Faded Short Sleeve T-shirts' and @class='product_img_link']");
    private SelenideElement moreButton = $x("//*[@title='View']");

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public TshirtsProductGridPage hoverOverFadedTshirt() {
        fadedTshirtTile.shouldHave(Condition.visible).hover();
        return this;
    }

    public FadedTshirtPage clickMoreButton() {
        moreButton.shouldBe(Condition.visible).click();
        return new FadedTshirtPage();
    }
}
