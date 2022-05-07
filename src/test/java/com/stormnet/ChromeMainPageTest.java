package com.stormnet;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class ChromeMainPageTest {
    private static final String mainPage = "https://www.onliner.by/";
    private static final SelenideElement CATALOG_XPATH = $x("//a[@href = \"https://catalog.onliner.by\" " +
            "and @class = \"b-main-navigation__link\"]");
    private static final SelenideElement compCatalog = $(".catalog-navigation-classifier__item-title");

    @FindBy(xpath = "//a[@href = \"https://catalog.onliner.by\" and @class = \"b-main-navigation__link\"]")
    private static WebElement CATALOG_XPATH2;

    @Test
    public void testOpenPage() {
        open(mainPage);
        CATALOG_XPATH.click();
        compCatalog.click();

        Selenide.closeWebDriver();
    }

    @Test
    public void testPrintTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\natalia.shukalovich\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(mainPage);
        System.out.println("Page title is: " + driver.getTitle());
        driver.findElement(By.xpath("//a[@href = \"https://catalog.onliner.by\" and @class = \"b-main-navigation__link\"]")).click();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
