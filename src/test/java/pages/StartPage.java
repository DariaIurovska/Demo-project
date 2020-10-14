package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class StartPage extends BasePage {

    WebDriver driver;

    By langSelectElementBy = By.xpath("//h1[contains(text(),'Language selection')]");
    By uaLangBtnBy = By.xpath("//li[contains(text(),'Українська')]");
    By ruLangBtnBy = By.xpath("//li[contains(text(),'Русский')]");
    By enLangBtnBy = By.xpath("//li[contains(text(),'English')]");
    By langBottomTextBy = By.xpath("//div[@class='text_left']");

    public StartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public StartPage open() {
        driver.get(PropertyLoader.loadProperty("baseURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(langSelectElementBy));
        return this;
    }

    public StartPage selectUaLangVersion() {
        driver.findElement(uaLangBtnBy).click();
        return this;
    }

    public StartPage selectRuLangVersion() {
        driver.findElement(ruLangBtnBy).click();
        return this;
    }

    public StartPage selectEnLangVersion() {
        driver.findElement(enLangBtnBy).click();
        return this;
    }

    public String findBottomText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(langBottomTextBy));
        return driver.findElement(langBottomTextBy).getText().toLowerCase();
    }
}