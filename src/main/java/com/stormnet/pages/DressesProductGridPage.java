package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DressesProductGridPage extends BasePage{

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement casualDressesButton = $x("//div[@id='left_column']//h2[contains(text(),'Dresses')]/following-sibling::div//a[contains(text(), 'Casual Dresses')]");
    private SelenideElement printedDressTile = $x("//a[@title='Printed Dress' and @class='product-name']");
    private SelenideElement addToCartButton = $x("//a[@title='Add to cart']");
    private SelenideElement successfullyAddedLabel = $x("//i[@class='icon-ok']/ancestor::h2");
    private SelenideElement proceedToCheckoutButton = $x("//*[@title='Proceed to checkout']");

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public DressesProductGridPage clickOnCasualDressesButton() {
        casualDressesButton.shouldHave(Condition.visible).click();
        return this;
    }

    public DressesProductGridPage hoverOverPrintedDress() {
        printedDressTile.shouldHave(Condition.visible).hover();
        return this;
    }

    public DressesProductGridPage clickOnAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public boolean verifyIfProductAddedToCart(String message) {
        return successfullyAddedLabel.shouldHave(Condition.text(message)).isDisplayed();
    }

    public CartSummaryPage clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.shouldBe(Condition.visible).click();
        return new CartSummaryPage();
    }

}
