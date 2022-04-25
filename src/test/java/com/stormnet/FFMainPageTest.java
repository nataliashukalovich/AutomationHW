package com.stormnet;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class FFMainPageTest {
    private final String mainPage = "https://belavia.by/";
    private final String newsPage = "https://belavia.by/novosti/";

    @Test
    public void testOpenPage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\natalia.shukalovich\\test\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(mainPage);
        driver.get(newsPage);
        driver.quit();
    }

    @Test
    public void testPrintTitle() {
        open(mainPage);
        System.out.println("Title of the page is: " + title());
        open(newsPage);
        System.out.println("Title of the page is: " + title());
        Selenide.closeWebDriver();
    }

}
