package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class RuHomePage extends BasePage {

    WebDriver driver;

    By langHeaderBy = By.xpath("//div[@class='lang_container_header']");
    By ruActiveLangBtnBy = By.xpath("//a[@class=' newlang active']");
    By mainMenuBtnBy = By.xpath("//img[@class='sb-toggle-left menu_ico']");

    public RuHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RuHomePage open() {
        driver.get(PropertyLoader.loadProperty("ruPageURL"));
        return this;
    }

    public WebElement findLangHeaderActiveText() {
        wait.until(ExpectedConditions.elementToBeClickable(langHeaderBy));
        return driver.findElement(ruActiveLangBtnBy);
    }

    public RuHomePage selectMainMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(mainMenuBtnBy));
        driver.findElement(mainMenuBtnBy).click();
        return this;
    }
}