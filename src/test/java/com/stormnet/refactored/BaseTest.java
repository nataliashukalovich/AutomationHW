package com.stormnet.refactored;

import com.codeborne.selenide.Selenide;
import com.stormnet.pages.LoginPage;
import com.stormnet.pages.MainPage;
import com.stormnet.pages.MyAccountPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;

public abstract class BaseTest {

    protected static final String BASE_URL = "http://automationpractice.com";

    protected static final String EMAIL = "natallie.ponomareva@gmail.com";
    protected static final String PW = "ZHB@fq86S7Kp29K";
    protected static final String RANDOM_EMAIL = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    protected static final String NAME = "Ivan";
    protected static final String SURNAME = "Ivanov";
    protected static final String PSSWD = "12345";
    protected static final String BIRTHDAY = "1";
    protected static final String BIRTHMONTH = "1";
    protected static final String BIRTHYEAR = "2020";
    protected static final String COMPANYNAME = "Kaseya";
    protected static final String ADDRESSVALUE = "701 Brickell Avenue";
    protected static final String CITY_VALUE = "Miami";
    protected static final String STATE_VALUE = "9";
    protected static final String ZIP_VALUE = "33131";
    protected static final String OTHER_VALUE = "Additional Information";
    protected static final String HOME_PHONE_VALUE = "+375292929297";
    protected static final String MOBILE_PHONE_VALUE = "+375333333333";
    protected static final String ALIAS_VALUE = "18, Baker Street";

}
