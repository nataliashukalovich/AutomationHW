package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreateAccountPage extends BasePage{

    private SelenideElement pageHeaderAuthentication = $(By.className("navigation_page"));

    @Override
    public boolean isPageOpened() {
        return pageHeaderAuthentication.isDisplayed();
    }

    private SelenideElement title = $(byId("id_gender1"));
    private SelenideElement customerFirstName = $(byId("customer_firstname"));
    private SelenideElement customerLastname = $(byId("customer_lastname"));
    private SelenideElement password = $(byId("passwd"));
    private SelenideElement dayOfBirth = $(byId("days"));
    private SelenideElement monthOfBirth = $(byId("months"));
    private SelenideElement yearOfBirth = $(byId("years"));
    private SelenideElement newsletterCheckbox = $(byId("newsletter"));
    private SelenideElement receiveOffersCheckbox = $(byId("optin"));
    private SelenideElement company = $(byId("company"));
    private SelenideElement address = $(byId("address1"));
    private SelenideElement city = $(byId("city"));
    private SelenideElement state = $(byId("id_state"));
    private SelenideElement postcode = $(byId("postcode"));
    private SelenideElement additionalInformation = $(byId("other"));
    private SelenideElement homePhone = $(byId("phone"));
    private SelenideElement mobilePhone = $(byId("phone_mobile"));
    private SelenideElement aliasAddress = $(byId("alias"));
    private SelenideElement registrationButton = $(byId("submitAccount"));

    public CreateAccountPage selectTitle() {
        title.should(visible, Duration.ofSeconds(20)).click();
        return this;
    }

    public CreateAccountPage enterCustomerFirstName(String firstname) {
        customerFirstName.should(visible, Duration.ofSeconds(20)).setValue(firstname);
        return this;
    }

    public CreateAccountPage enterCustomersLastName(String secondname) {
        customerLastname.should(visible, Duration.ofSeconds(20)).setValue(secondname);
        return this;
    }

    public CreateAccountPage enterPassword(String pass) {
        password.should(visible, Duration.ofSeconds(20)).setValue(pass);
        return this;
    }

    public CreateAccountPage enterDayOfBirth(String bday) {
        dayOfBirth.selectOptionByValue(bday);
        return this;
    }

    public CreateAccountPage enterMonthOfBirth(String monthofbirth) {
        monthOfBirth.selectOptionByValue(monthofbirth);
        return this;
    }

    public CreateAccountPage enterYearOfBirth(String yearofbirth) {
        yearOfBirth.selectOptionByValue(yearofbirth);
        return this;
    }

    public CreateAccountPage markNewsletterCheckbox() {
        newsletterCheckbox.click();
        return this;
    }

    public CreateAccountPage markOffersCheckbox() {
        receiveOffersCheckbox.click();
        return this;
    }

    public CreateAccountPage enterCompanyName(String companyname) {
        company.should(visible, Duration.ofSeconds(20)).setValue(companyname);
        return this;
    }

    public CreateAccountPage enterAddress(String valueofaddress) {
        address.should(visible, Duration.ofSeconds(20)).setValue(valueofaddress);
        return this;
    }

    public CreateAccountPage enterCity(String cityvalue) {
        city.should(visible, Duration.ofSeconds(20)).setValue(cityvalue);
        return this;
    }

    public CreateAccountPage enterState(String statevalue) {
        state.selectOptionByValue(statevalue);
        return this;
    }

    public CreateAccountPage enterZipcode(String zipcodevalue) {
        postcode.should(visible, Duration.ofSeconds(20)).setValue(zipcodevalue);
        return this;
    }

    public CreateAccountPage addOtherInfo(String otherdata) {
        additionalInformation.should(visible, Duration.ofSeconds(20)).setValue(otherdata);
        return this;
    }

    public CreateAccountPage addHomePhone(String phonehome) {
        homePhone.should(visible, Duration.ofSeconds(20)).setValue(phonehome);
        return this;
    }

    public CreateAccountPage addMobilePhone(String phonemobile) {
        mobilePhone.should(visible, Duration.ofSeconds(20)).setValue(phonemobile);
        return this;
    }

    public CreateAccountPage addAliasAddress(String aliasaddress) {
        aliasAddress.should(visible, Duration.ofSeconds(20)).setValue(aliasaddress);
        return this;
    }

    public MyAccountPage clickRegisterButton() {
        registrationButton.should(visible, Duration.ofSeconds(20)).click();
        return new MyAccountPage();
    }
}
