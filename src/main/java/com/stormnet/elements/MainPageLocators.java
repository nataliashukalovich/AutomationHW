package com.stormnet.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPageLocators {
    private static final String mainPage = "http://automationpractice.com/index.php";
    private static final SelenideElement SIGN_IN_BTN = $x("//*[@class='login']");
    private static final SelenideElement EMAIL_INPUT = $(byId("email"));
    private static final SelenideElement PASSWORD_INPUT = $(byId("passwd"));
    private static final SelenideElement INFO_ACCOUNT = $x("//p[@class='info-account']");
    private static final SelenideElement SUBMITLOGIN_BTN = $(byId("SubmitLogin"));
}
