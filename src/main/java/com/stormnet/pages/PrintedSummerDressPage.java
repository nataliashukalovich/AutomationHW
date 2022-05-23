package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PrintedSummerDressPage extends BasePage {

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement blackColorCheckbox = $(byId("color_11"));
    private SelenideElement orangeColorCheckbox = $(byId("color_13"));
    private SelenideElement blueColorCheckbox = $(byId("color_14"));
    private SelenideElement yellowColorCheckbox = $(byId("color_16"));

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public PrintedSummerDressPage selectBlackColor() {
        blackColorCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    public PrintedSummerDressPage selectOrangeColor() {
        orangeColorCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    public PrintedSummerDressPage selectBlueColor() {
        blueColorCheckbox.shouldBe(Condition.visible).click();
        return this;
    }

    public PrintedSummerDressPage selectYellowColor() {
        yellowColorCheckbox.shouldBe(Condition.visible).click();
        return this;
    }
}
