package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    private SelenideElement logo = $(byId("header_logo"));
    private SelenideElement cartLabel = $(byClassName("shopping_cart"));
    private SelenideElement signInButton = $(byClassName("login"));

    @Override
    public boolean isPageOpened() {
        return logo.isDisplayed() && cartLabel.isDisplayed();
    }

    public LoginPage clickSignInBtn() {
        signInButton.shouldHave(Condition.visible).click();
        return new LoginPage();
    }

}
