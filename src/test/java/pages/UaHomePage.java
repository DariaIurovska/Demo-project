package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class UaHomePage extends BasePage {

    WebDriver driver;

    By langHeaderBy = By.xpath("//div[@class='lang_container_header']");
    By uaRuActiveLangBtnBy = By.xpath("//a[@class=' newlang active']");

    public UaHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public UaHomePage open() {
        driver.get(PropertyLoader.loadProperty("uaPageURL"));
        return this;
    }

    public WebElement findLangHeaderActiveText() {
        wait.until(ExpectedConditions.elementToBeClickable(langHeaderBy));
        return driver.findElement(uaRuActiveLangBtnBy);
    }

}