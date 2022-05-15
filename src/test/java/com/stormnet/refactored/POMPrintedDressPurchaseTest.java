package com.stormnet.refactored;

import com.codeborne.selenide.Selenide;
import com.stormnet.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class POMPrintedDressPurchaseTest extends BaseTest {

    private static final String ADDED_TO_CART_MESSAGE = "Product successfully added to your shopping cart";

    @Test
    public void testOrderCasualDress() {
        MainPage mainPage = Selenide.open(BASE_URL, MainPage.class);
        Assertions.assertTrue(mainPage.isPageOpened(), "Main page was not opened!");
        LoginPage loginPage = mainPage.clickSignInBtn();
        Assertions.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");
        MyAccountPage myAccountPage = loginPage.login(EMAIL, PW);
        Assertions.assertTrue(myAccountPage.isPageOpened(), "Expected message hasn't appeared");
        ProductGridPage productGridPage = myAccountPage.clickOnDressesButton();
        Assertions.assertTrue(productGridPage.isPageOpened(), "Page with products hasn't opened");
        productGridPage
                .clickOnCasualDressesButton()
                .hoverOverPrintedDress()
                .clickOnAddToCartButton();
        Assertions.assertTrue(productGridPage.verifyIfProductAddedToCart(ADDED_TO_CART_MESSAGE),
                "Expected message 'Added to cart' isn't displayed");
        CartSummaryPage cartSummaryPage = productGridPage.clickOnProceedToCheckoutButton();
        Assertions.assertTrue(cartSummaryPage.isPageOpened(), "Cart summary page hasn't opened");
        cartSummaryPage
                .switchToAddressesTab()
                .switchToShippingTab()
                .markIAgreeCheckbox()
                .switchToPaymentTab()
                .choosePayByBankButton()
                .confirmOrder();
        Assertions.assertTrue(cartSummaryPage.isOrderConfirmed(), "Order is not confirmed!");

    }

}

