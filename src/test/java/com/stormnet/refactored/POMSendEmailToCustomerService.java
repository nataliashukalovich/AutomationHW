package com.stormnet.refactored;

import com.codeborne.selenide.Selenide;
import com.stormnet.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class POMSendEmailToCustomerService extends BaseTest {
    private static final String ADDED_TO_CART_MESSAGE = "Product successfully added to your shopping cart";

    @Test
    public void sendEmailToCustomerServiceTest() {
        MainPage mainPage = Selenide.open(BASE_URL, MainPage.class);
        Assertions.assertTrue(mainPage.isPageOpened(), "Main page was not opened!");
        LoginPage loginPage = mainPage.clickSignInBtn();
        Assertions.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");
        loginPage.enterRandomEmail(RANDOM_EMAIL);
        CreateAccountPage createAccountPage = loginPage.clickOnRegisterButton();
        Assertions.assertTrue(createAccountPage.isPageOpened(), "Registration page hasn't opened");
        createAccountPage.selectTitle()
                .enterCustomerFirstName(NAME)
                .enterCustomersLastName(SURNAME)
                .enterPassword(PSSWD)
                .enterDayOfBirth(BIRTHDAY)
                .enterMonthOfBirth(BIRTHMONTH)
                .enterYearOfBirth(BIRTHYEAR)
                .markNewsletterCheckbox()
                .markOffersCheckbox()
                .enterAddress(ADDRESSVALUE)
                .enterCity(CITY_VALUE)
                .enterState(STATE_VALUE)
                .enterZipcode(ZIP_VALUE)
                .addOtherInfo(OTHER_VALUE)
                .addHomePhone(HOME_PHONE_VALUE)
                .addMobilePhone(MOBILE_PHONE_VALUE)
                .addAliasAddress(ALIAS_VALUE);
        MyAccountPage myAccountPage = createAccountPage.clickRegisterButton();
        Assertions.assertTrue(myAccountPage.isPageOpened());
        DressesProductGridPage productGridPage = myAccountPage.clickOnDressesButton();
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
