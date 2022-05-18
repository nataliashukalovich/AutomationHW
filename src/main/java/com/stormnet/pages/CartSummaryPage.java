package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartSummaryPage extends BasePage{

    @FindBy(id = "cart_title")
    private SelenideElement cartTitleLabel;

    @FindBy(xpath = "//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']")
    private SelenideElement proceedToCheckoutSummary;

    @FindBy(xpath = "//*[@type='submit']//span[.='Proceed to checkout']")
    private SelenideElement proceedToCheckoutAdresses;

    @FindBy(id="cgv")
    private SelenideElement checkboxIAgree;

    @FindBy(xpath = "//*[@name='processCarrier']")
    private SelenideElement proceedToCheckoutShipping;

    @FindBy(xpath = "//*[@title='Pay by bank wire']")
    private SelenideElement payByBankButton;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private SelenideElement confirmOrderButton;

    @FindBy(xpath = "//*[contains(text(), 'Your order on My Store is complete.')]")
    private SelenideElement orderConfirmationTextLabel;

    @Override
    public boolean isPageOpened() {
        return cartTitleLabel.isDisplayed();
    }

    public CartSummaryPage switchToAddressesTab() {
        proceedToCheckoutSummary.shouldBe(Condition.visible).click();
        return this;
    }

    public CartSummaryPage switchToShippingTab() {
        proceedToCheckoutAdresses.shouldBe(Condition.visible).click();
        return this;
    }

    public CartSummaryPage markIAgreeCheckbox() {
        checkboxIAgree.click();
        return this;
    }

    public CartSummaryPage switchToPaymentTab() {
        proceedToCheckoutShipping.shouldBe(Condition.visible).click();
        return this;
    }

    public CartSummaryPage choosePayByBankButton() {
        payByBankButton.shouldBe(Condition.visible).click();
        return this;
    }

    public CartSummaryPage confirmOrder() {
        confirmOrderButton.shouldBe(Condition.visible).click();
        return this;
    }

    public boolean isOrderConfirmed() {
        return orderConfirmationTextLabel.isDisplayed();
    }
}
