package com.stormnet;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ChromeMainPageTest {
    private static final String mainPage = "https://www.onliner.by/";
    private static final String CATALOG_XPATH = "//a[@href = \"https://catalog.onliner.by\" and @class = \"b-main-navigation__link\"]";

    @Test
    public void testOpenPage() {
        open(mainPage);
        $(byXpath(CATALOG_XPATH)).click();
        Selenide.closeWebDriver();
    }

    @Test
    public void testPrintTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\natalia.shukalovich\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(mainPage);
        System.out.println("Page title is: " + driver.getTitle());
        driver.findElement(By.xpath(CATALOG_XPATH)).click();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
