package com.stormnet.refactored;

import com.codeborne.selenide.Selenide;
import com.stormnet.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WriteReviewAboutTshirt extends BaseTest {

    private static final String UR_COMMENT_BEEN_ADDED = "Your comment has been added and will be available once approved by a moderator";

    @Test
    public void writeReviewAboutTshirt() {
    MainPage mainPage = Selenide.open(BASE_URL, MainPage.class);
    Assertions.assertTrue(mainPage.isPageOpened(),"Main page was not opened!");
    LoginPage loginPage = mainPage.clickSignInBtn();
    Assertions.assertTrue(loginPage.isPageOpened(),"Login page was not opened!");
    MyAccountPage myAccountPage = loginPage.login(CUSTOMERS_EMAIL, CUSTOMERS_PW);
    Assertions.assertTrue(myAccountPage.isPageOpened(),"Expected message hasn't appeared");
    TshirtsProductGridPage tshirtsProductGridPage = myAccountPage.clickOnTshirtsButton();
    Assertions.assertTrue(tshirtsProductGridPage.isPageOpened(), "Page with T-shirts wasn't opened!");
    tshirtsProductGridPage.hoverOverFadedTshirt();
    FadedTshirtPage fadedTshirtPage = tshirtsProductGridPage.clickMoreButton();
    Assertions.assertTrue(fadedTshirtPage.isPageOpened(), "Page with product wasn't opened!");
    fadedTshirtPage.clickWriteReviewButton()
                    .setFiveStars()
                    .addCommentTitle(COMMENT_TITLE)
                    .addCommentText(COMMENT_BODY)
                    .clickOnSendButton();
    Assertions.assertTrue(fadedTshirtPage.verifyIfCommentBeenAdded(UR_COMMENT_BEEN_ADDED),
            "Message 'Your comment has ben added' hasn't appeared!");
    fadedTshirtPage.clickOnOKButton();
    Assertions.assertTrue(fadedTshirtPage.isPageOpened(), "Page with product wasn't opened!");
}
}
