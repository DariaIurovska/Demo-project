package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class EnHomePage extends BasePage{

    WebDriver driver;

    By langHeaderBy = By.xpath("//div[@class='lang_container_header']");
    By enActiveLangBtnBy = By.xpath("//a[@class='  newlang active']");

    public EnHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EnHomePage open() {
        driver.get(PropertyLoader.loadProperty("enPageURL"));
        return this;
    }

    public WebElement findLangHeaderActiveText() {
        wait.until(ExpectedConditions.elementToBeClickable(langHeaderBy));
        return driver.findElement(enActiveLangBtnBy);
    }
}
