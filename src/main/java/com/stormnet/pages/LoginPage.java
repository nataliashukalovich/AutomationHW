package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private SelenideElement pageHeader = $(byClassName("page-heading"));
    private SelenideElement emailInput = $(byId("email"));
    private SelenideElement passwordInput = $(byId("passwd"));
    private SelenideElement submitLoginButton = $(byId("SubmitLogin"));
    private SelenideElement enterEmailForRegistration = $(byId("email_create"));
    private SelenideElement registrationButton = $(byId("SubmitCreate"));

    @Override
    public boolean isPageOpened() {
        return pageHeader.isDisplayed();
    }

    public MyAccountPage login(String email, String pwd) {
        enterEmail(email);
        enterPW(pwd);
        return clickSubmitLoginButton();
    }

    public LoginPage enterEmail(String email) {
        emailInput.shouldHave(Condition.visible).setValue(email);
        return this;
    }

    public LoginPage enterPW(String pw) {
        passwordInput.shouldHave(Condition.visible).setValue(pw);
        return this;
    }

    public MyAccountPage clickSubmitLoginButton() {
        submitLoginButton.shouldHave(Condition.visible).click();
        return page(MyAccountPage.class);
    }

    public LoginPage enterRandomEmail(String emailvalue) {
        enterEmailForRegistration.shouldHave(Condition.visible).setValue(emailvalue);
        return this;
    }

    public CreateAccountPage clickOnRegisterButton() {
        registrationButton.shouldHave(Condition.visible).click();
        return new CreateAccountPage();
    }

}
