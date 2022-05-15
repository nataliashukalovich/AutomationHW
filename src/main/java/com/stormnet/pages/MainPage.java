package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    @FindBy(id = "header_logo")
    private SelenideElement logo;

    @FindBy(className = "shopping_cart")
    private SelenideElement cartLabel;

    @FindBy(className =  "login")
    private SelenideElement signInButton;

    @Override
    public boolean isPageOpened() {
        return logo.isDisplayed() && cartLabel.isDisplayed();
    }

    public LoginPage clickSignInBtn() {
        signInButton.shouldHave(Condition.visible).click();
        return page(LoginPage.class);
    }

}
