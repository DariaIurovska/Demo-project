package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Optional;
import test.java.utils.PropertyLoader;

public class HomePage extends BasePage {

    WebDriver driver;

    By langSelectElementBy = By.xpath("//h1[contains(text(),'Language selection')]");
    By uaLangBtnBy = By.xpath("//li[contains(text(),'Українська')]");
    By ruLangBtnBy = By.xpath("//li[contains(text(),'Русский')]");
    By enLangBtnBy = By.xpath("//li[contains(text(),'English')]");
    By langBottomTextBy = By.xpath("//div[@class='text_left']");


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public HomePage open() {
        driver.get(PropertyLoader.loadProperty("baseURL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(langSelectElementBy));
        return this;
    }

    public HomePage selectUaLangVersion() {
        driver.findElement(uaLangBtnBy).click();
        return this;
    }

    public HomePage selectRuLangVersion() {
        driver.findElement(ruLangBtnBy).click();
        return this;
    }

    public HomePage selectEnLangVersion() {
        driver.findElement(enLangBtnBy).click();
        return this;
    }


    public String findBottomText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(langBottomTextBy));
        String langBottomText = driver.findElement(langBottomTextBy).getText().toLowerCase();
        return langBottomText;
    }

}