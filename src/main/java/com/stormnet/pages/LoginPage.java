package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    @FindBy(className = "page-heading")
    private SelenideElement pageHeader;

    @FindBy(id = "email")
    private SelenideElement emailInput;

    @FindBy(id = "passwd")
    private SelenideElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private SelenideElement submitLoginButton;

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

}
