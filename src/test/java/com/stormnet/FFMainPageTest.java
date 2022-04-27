package com.stormnet;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class FFMainPageTest {
    private static final String mainPage = "https://belavia.by/";
    private static final String NEWSPAGE_XPATH = "//a[text()=\"Все новости\"]";

    @Test
    public void testOpenPage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\natalia.shukalovich\\test\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(mainPage);
        driver.findElement(By.xpath(NEWSPAGE_XPATH)).click();
        driver.quit();
    }

    @Test
    public void testPrintTitle() {
        open(mainPage);
        System.out.println("Title of the page is: " + title());
        $(byXpath(NEWSPAGE_XPATH)).click();
        System.out.println("Title of the page is: " + title());
        Selenide.closeWebDriver();
    }

}
