package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BlouseProductPage extends BasePage {

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement addToWishlistButton = $x("//a[@title='Add to my wishlist']");
    private SelenideElement closePopupButton = $x("//a[@title='Close']");
    private SelenideElement popUpText = $x("//p[@class='fancybox-error']");
    private SelenideElement myAccount = $(By.className("account"));


    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public BlouseProductPage clickOnAddToWishListButton() {
        addToWishlistButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public BlouseProductPage closePopup() {
        closePopupButton.shouldBe(Condition.visible).click();
        return this;
    }

    public boolean hasPopupAppeared() {
        return popUpText.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public MyAccountPage clickOnMyAccount() {
        myAccount.shouldBe(Condition.visible).click();
        return new MyAccountPage();
    }
}
