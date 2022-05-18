package com.stormnet.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreateAccountPage extends BasePage{
    @FindBy(className = "navigation_page")
    private SelenideElement pageHeaderAuthentication;

    @Override
    public boolean isPageOpened() {
        return pageHeaderAuthentication.isDisplayed();
    }

    @FindBy(id = "id_gender1")
    private SelenideElement title;

    @FindBy(id = "customer_firstname")
    private SelenideElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private SelenideElement customerLastname;

    @FindBy(id = "passwd")
    private SelenideElement password = $(byId("passwd"));

    @FindBy(id = "days")
    private SelenideElement dayOfBirth;

    @FindBy(id = "months")
    private SelenideElement monthOfBirth;

    @FindBy(id = "years")
    private SelenideElement yearOfBirth;

    @FindBy(id = "newsletter")
    private SelenideElement newsletterCheckbox;

    @FindBy(id = "optin")
    private SelenideElement receiveOffersCheckbox;

    @FindBy(id = "company")
    private SelenideElement company;

    @FindBy(id = "address1")
    private SelenideElement address;

    @FindBy(id = "city")
    private SelenideElement city;

    @FindBy(id = "id_state")
    private SelenideElement state;

    @FindBy(id = "postcode")
    private SelenideElement postcode;

    @FindBy(id = "other")
    private SelenideElement additionalInformation;

    @FindBy(id = "phone")
    private SelenideElement homePhone;

    @FindBy(id = "phone_mobile")
    private SelenideElement mobilePhone;

    @FindBy(id = "alias")
    private SelenideElement aliasAddress;

    @FindBy(id = "submitAccount")
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
        return page(MyAccountPage.class);
    }
}
