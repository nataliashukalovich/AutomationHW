package com.stormnet.refactored;

import com.codeborne.selenide.Selenide;
import com.stormnet.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBlouseToWishlist extends BaseTest {

    @Test
    public void addBlouseToWishlist() {
        MainPage mainPage = Selenide.open(BASE_URL, MainPage.class);
        Assertions.assertTrue(mainPage.isPageOpened(), "Main page was not opened!");
        LoginPage loginPage = mainPage.clickSignInBtn();
        Assertions.assertTrue(loginPage.isPageOpened(), "Login page was not opened!");
        MyAccountPage myAccountPage = loginPage.login(CUSTOMERS_EMAIL, CUSTOMERS_PW);
        Assertions.assertTrue(myAccountPage.isPageOpened(), "Expected message hasn't appeared");
        myAccountPage.hoverOverWomenButton();
        BlousesProductGridPage blousesProductGridPage = myAccountPage.clickOnBlousesButton();
        Assertions.assertTrue(blousesProductGridPage.isPageOpened(), "Page with blouses hasn't opened!");
        blousesProductGridPage.hoverOverBlouseTile();
        BlouseProductPage blouseProductPage = blousesProductGridPage.clickOnMoreButton();
        Assertions.assertTrue(blouseProductPage.isPageOpened(), "Page with blouse hasn't opened!");
        blouseProductPage.clickOnAddToWishListButton();
        Assertions.assertTrue(blouseProductPage.hasPopupAppeared(), "Pop-up with expected text hasn't appeared!");
        blouseProductPage.closePopup();
        Assertions.assertTrue(blouseProductPage.isPageOpened(), "Page with blouse hasn't opened!");
        MyAccountPage myAccountPage1 = blouseProductPage.clickOnMyAccount();
        Assertions.assertTrue(myAccountPage1.isPageOpened(), "My account page hasn't opened!");
        MyWishListsPage myWishListsPage = myAccountPage1.clickOnWishListsButton();
        Assertions.assertTrue(myWishListsPage.isPageOpened(), "The page with wishlists hasn't opened!");
        myWishListsPage.clickOnMyWishlist();
        Assertions.assertTrue(myWishListsPage.isBlouseAddedToWishlist(), "The blouse doesn't appear in wishlist!");
        Assertions.assertTrue(myWishListsPage.isQuantityDisplayed(), "Quantity isn't displayed!");
        Assertions.assertTrue(myWishListsPage.isPriorityDisplayed(), "Priority isn't displayed!");
        myWishListsPage.deleteWishList();
        Assertions.assertTrue(myWishListsPage.hasWishListBeenCleared(), "The blouse is still in the wishlist!");
    }
}
