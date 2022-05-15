package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ProductGridPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'breadcrumb')]")
    private SelenideElement breadcrumb;

    @FindBy(xpath = "//div[@id='left_column']//h2[contains(text(),'Dresses')]/following-sibling::div//a[contains(text(), 'Casual Dresses')]")
    private SelenideElement casualDressesButton;

    @FindBy(xpath = "//a[@title='Printed Dress' and @class='product-name']")
    private SelenideElement printedDressTile;

    @FindBy(xpath = "//a[@title='Add to cart']")
    private SelenideElement addToCartButton;

    @FindBy(xpath = "//i[@class='icon-ok']/ancestor::h2")
    private SelenideElement successfullyAddedLabel;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    private SelenideElement proceedToCheckoutButton;

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public ProductGridPage clickOnCasualDressesButton() {
        casualDressesButton.shouldHave(Condition.visible).click();
        return this;
    }

    public ProductGridPage hoverOverPrintedDress() {
        printedDressTile.shouldHave(Condition.visible).hover();
        return this;
    }

    public ProductGridPage clickOnAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public boolean verifyIfProductAddedToCart(String message) {
        return successfullyAddedLabel.shouldHave(Condition.text(message)).isDisplayed();
    }

    public CartSummaryPage clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.shouldBe(Condition.visible).click();
        return page(CartSummaryPage.class);
    }

}
