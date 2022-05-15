package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MyAccountPage extends BasePage {

    @FindBy(className = "info-account")
    private SelenideElement infoAccount;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    private SelenideElement dressesButton;

    @Override
    public boolean isPageOpened() {
        return infoAccount.isDisplayed();
    }

    public ProductGridPage clickOnDressesButton() {
        dressesButton.shouldHave(Condition.visible).click();
        return page(ProductGridPage.class);
    }
}
