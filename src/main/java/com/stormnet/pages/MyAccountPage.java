package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage extends BasePage {

    private SelenideElement infoAccount = $(By.className("info-account"));
    private SelenideElement dressesButton = $x("(//a[@title='Dresses'])[2]");
    private SelenideElement tShirtsButton = $x("(//a[@title='T-shirts'])[2]");

    @Override
    public boolean isPageOpened() {
        return infoAccount.isDisplayed();
    }

    public TshirtsProductGridPage clickOnTshirtsButton() {
        tShirtsButton.shouldHave(Condition.visible, Duration.ofSeconds(10)).click();
        return new TshirtsProductGridPage();
    }
    public DressesProductGridPage clickOnDressesButton() {
        dressesButton.shouldHave(Condition.visible).click();
        return new DressesProductGridPage();
    }

}
