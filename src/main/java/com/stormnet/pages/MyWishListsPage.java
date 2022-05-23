package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MyWishListsPage extends BasePage {

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement myWishListRow = $x("//a[contains(text(), 'My wishlist')]");
    private SelenideElement addedBlouseTile = $x("(//a[@title='Product detail'])[1]");
    private SelenideElement quantityNumber = $(byId("quantity_2_7"));
    private SelenideElement priorityValue = $(byId("priority_2_7"));
    private SelenideElement deleteWishlistButton = $x("//i[@class='icon-remove-sign']");

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public MyWishListsPage clickOnMyWishlist() {
        myWishListRow.shouldBe(Condition.visible).click();
        return this;
    }

    public boolean isBlouseAddedToWishlist() {
        return addedBlouseTile.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isQuantityDisplayed() {
        return quantityNumber.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isPriorityDisplayed() {
        return priorityValue.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public MyWishListsPage deleteWishList() {
        deleteWishlistButton.shouldBe(Condition.visible).click();
        return this;
    }

    public boolean hasWishListBeenCleared() {
        return addedBlouseTile.should(disappear).is(disappear);
    }
}
