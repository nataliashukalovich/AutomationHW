package com.stormnet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import javax.xml.xpath.XPath;

public class TestCase1 {

    private static final String mainPage = "http://automationpractice.com/index.php";
    private static final SelenideElement SIGN_IN_BTN = $x("//*[@class='login']");
    private static final SelenideElement EMAIL_INPUT = $(byId("email"));
    private static final SelenideElement PASSWORD_INPUT = $(byId("passwd"));
    private static final SelenideElement INFO_ACCOUNT = $x("//p[@class='info-account']");
    private static final SelenideElement SUBMITLOGIN_BTN = $(byId("SubmitLogin"));
    private static final String EMAIL = "natallie.ponomareva@gmail.com";
    private static final String PW = "ZHB@fq86S7Kp29K";
    private static final SelenideElement DRESSES_BTN = $x("(//a[@title='Dresses'])[2]");
    private static final SelenideElement CASUAL_DRESSES = $x("//div[@id='left_column']//h2[contains(text(),'Dresses')]/following-sibling::div//a[contains(text(), 'Casual Dresses')]");
    private static final SelenideElement PRINTED_DRESS = $x("//a[@title='Printed Dress' and @class='product-name']");
    private static final SelenideElement ADD_TO_CART = $x("//a[@title='Add to cart' and @class='button ajax_add_to_cart_button btn btn-default']");
    private static final SelenideElement SUCCESSFULLY_ADDED = $x("//i[@class='icon-ok']/ancestor::h2");
    private static final SelenideElement PROCEED_TO_CHECKOUT = $x("//*[@title='Proceed to checkout']");
    private static final SelenideElement PROCEED_AGAIN_TO_CHECKOUT = $x("//a[@title='Proceed to checkout' " +
            "and @class='button btn btn-default standard-checkout button-medium']");
    private static final SelenideElement SUBMIT_CHECKOUT = $x("//*[@type='submit']//span[.='Proceed to checkout']");
    private static final SelenideElement MARK_CHECKBOX = $(byId("cgv"));
    private static final SelenideElement LAST_CHECKOUT = $x("//*[@name='processCarrier']");
    private static final SelenideElement PAY_BY_BANK = $x("//*[@title='Pay by bank wire']");
    private static final SelenideElement CONFIRM_ORDER = $x("//button[@class='button btn btn-default button-medium']");
    private static final SelenideElement FINAL_TEXT = $x("//*[contains(text(), 'Your order on My Store is complete')]");

    @Test
    public void testOpenMainPage() {
        open(mainPage);
        Assertions.assertTrue(SIGN_IN_BTN.isDisplayed(), "Main page is not opened!");

        clickSignInBtn();
        Assertions.assertTrue(SUBMITLOGIN_BTN.isDisplayed(), "Login page was not opened!");

        enterEmail(EMAIL);
        enterPW(PW);

        submitLogin();
        Assertions.assertEquals("Welcome to your account. Here you can manage all of your personal information" +
                " and orders.", INFO_ACCOUNT.getText(), "Account info text mismatched");

        clickDressesBtn();
        Assertions.assertTrue(DRESSES_BTN.isDisplayed(), "Page with dresses doesn't open!");

        clickCasualDressesBtn();

        selectPrintedDress();
        Assertions.assertNotNull(ADD_TO_CART.shouldBe(Condition.visible), "Can't hover over the printed dress");

        addPrintedDressToCart();
        Assertions.assertEquals("Product successfully added to your shopping cart", SUCCESSFULLY_ADDED.getText(),
                "Expected text hasn't appeared!");

        proceedToCheckout();
        proceedAgainToCheckout();
        submitCheckout();
        markCheckbox();
        lastCheckout();
        payByBank();

        confirmOrder();
        Assertions.assertEquals("Your order on My Store is complete", FINAL_TEXT.getText(), "Text about completing order hasn't appeared");
    }
    public void clickSignInBtn() {
        SIGN_IN_BTN.click();
    }
    public void enterEmail(String email) {
        EMAIL_INPUT.setValue(email);
    }
    public void enterPW(String pw) {
        PASSWORD_INPUT.setValue(pw);
    }
    public void submitLogin() {
        SUBMITLOGIN_BTN.click();
    }
    public void clickDressesBtn() {
        DRESSES_BTN.click();
    }
    public void clickCasualDressesBtn() {
        CASUAL_DRESSES.click();
    }
    public void selectPrintedDress() {
        PRINTED_DRESS.hover();
    }
    public void addPrintedDressToCart() {
        ADD_TO_CART.click();
    }
    public void proceedToCheckout() {
        PROCEED_TO_CHECKOUT.click();
    }
    public void proceedAgainToCheckout() {
        PROCEED_AGAIN_TO_CHECKOUT.click();
    }
    public void submitCheckout() {
        SUBMIT_CHECKOUT.click();
    }
    public void markCheckbox() {
        MARK_CHECKBOX.click();
    }
    public void lastCheckout() {
        LAST_CHECKOUT.click();
    }
    public void payByBank() {
        PAY_BY_BANK.click();
    }
    public void confirmOrder() {
        CONFIRM_ORDER.click();
    }
}
