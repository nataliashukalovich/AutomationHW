package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FadedTshirtPage extends BasePage{

    private SelenideElement breadcrumb = $x("//div[contains(@class, 'breadcrumb')]");
    private SelenideElement writeReviewButton = $x("//a[@class='open-comment-form']");
    private SelenideElement fiveStars = $x("//*[@title='5']//parent::div");
    private SelenideElement commentTitleField = $(byId("comment_title"));
    private SelenideElement commentTextField = $(byId("content"));
    private SelenideElement sendButton = $(byId("submitNewMessage"));
    private SelenideElement yourCommentBeenAdded = $x("//*[text()='Your comment has been added and will be available once approved by a moderator']");
    private SelenideElement submitOkButton = $x("//button[@type='submit' and @value='true']");

    @Override
    public boolean isPageOpened() {
        return breadcrumb.isDisplayed();
    }

    public FadedTshirtPage clickWriteReviewButton() {
        writeReviewButton.shouldBe(Condition.visible).click();
        return this;
    }

    public FadedTshirtPage setFiveStars() {
        fiveStars.shouldBe(Condition.visible).click();
        return this;
    }

    public FadedTshirtPage addCommentTitle(String commentHeader) {
        commentTitleField.setValue(commentHeader);
        return this;
    }

    public FadedTshirtPage addCommentText(String commentText) {
        commentTextField.setValue(commentText);
        return this;
    }

    public FadedTshirtPage clickOnSendButton() {
        sendButton.shouldBe(Condition.visible).click();
        return this;
    }

    public boolean verifyIfCommentBeenAdded(String message) {
        return yourCommentBeenAdded.shouldHave(Condition.text(message)).isDisplayed();
    }

    public FadedTshirtPage clickOnOKButton() {
        submitOkButton.shouldBe(Condition.visible).click();
        return this;
    }
}
