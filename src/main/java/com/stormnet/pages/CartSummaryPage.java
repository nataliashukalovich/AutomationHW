package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartSummaryPage extends BasePage{

    private SelenideElement cartTitleLabel = $(byId("cart_title"));
    private SelenideElement proceedToCheckoutSummary = $x("//a[@title='Proceed to checkout' " +
            "and @class='button btn btn-default standard-checkout button-medium']");
    private SelenideElement proceedToCheckoutAdresses = $x("//*[@type='submit']//span[.='Proceed to checkout']");
    private SelenideElement checkboxIAgree = $(byId("cgv"));
    private SelenideElement proceedToCheckoutShipping = $x("//*[@name='processCarrier']");
    private SelenideElement payByBankButton = $x("//*[@title='Pay by bank wire']");
    private SelenideElement confirmOrderButton = $x("//button[@class='button btn btn-default button-medium']");
    private SelenideElement orderConfirmationTextLabel = $x("//*[contains(text(), 'Your order on My Store is complete.')]");

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
