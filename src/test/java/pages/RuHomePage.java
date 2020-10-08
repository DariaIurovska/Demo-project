package test.java.pages;

import org.apache.tools.ant.taskdefs.LoadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class RuHomePage extends BasePage {

    WebDriver driver;

    By langHeaderBy = By.xpath("//div[@class='lang_container_header']");
    By uaRuActiveLangBtnBy = By.xpath("//a[@class=' newlang active']");

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
        return driver.findElement(uaRuActiveLangBtnBy);
    }

}
