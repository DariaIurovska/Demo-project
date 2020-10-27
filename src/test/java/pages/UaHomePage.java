package test.java.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class UaHomePage extends BasePage {

    WebDriver driver;

    By langHeaderBy = By.xpath("//div[@class='lang_container_header']");
    By uaActiveLangBtnBy = By.xpath("//a[@class=' newlang active']");
    By mainMenuBtnBy = By.xpath("//img[@class='sb-toggle-left menu_ico']");

    public UaHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step(value="UA-home page open")
    @Override
    public UaHomePage open() {
        driver.get(PropertyLoader.loadProperty("uaPageURL"));
        return this;
    }

    @Step(value="UA-home page find active text in language button at header")
    public WebElement findLangHeaderActiveText() {
        wait.until(ExpectedConditions.elementToBeClickable(langHeaderBy));
        return driver.findElement(uaActiveLangBtnBy);
    }

    @Step(value="UA-home page click Main menu")
    public UaHomePage selectMainMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(mainMenuBtnBy));
        driver.findElement(mainMenuBtnBy).click();
        return this;
    }
}