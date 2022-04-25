package com.stormnet;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;


public class ChromeMainPageTest {
    private final String mainPage = "https://www.onliner.by/";
    private final String catalogPage = "https://catalog.onliner.by/";

    @Test
    public void testOpenPage() {
        open(mainPage);
        open(catalogPage);
        Selenide.closeWebDriver();
    }

    @Test
    public void testPrintTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\natalia.shukalovich\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(mainPage);
        System.out.println("Page title is: " + driver.getTitle());
        driver.get(catalogPage);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
