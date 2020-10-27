package test.java.tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import test.java.pages.*;

public class RuPageMenuSelectionMatchesSelectPageTitleTest extends TestBaseSetUp {

    StartPage startPage;
    RuHomePage ruHomePage;

    final String sampleForSubMenuBtnLocator = "a[href='/catalog/*/']";
    final String sampleForPageTitleLocator = "//span/a[@href='/catalog/*/']";

    @BeforeMethod
    public void pageFactory() {
        startPage = new StartPage(driver);
        ruHomePage = new RuHomePage(driver);
    }

    @Epic("Web-site Main menu")
    @Feature("Russian version web-site menu")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will find out if language on the page which have been selected from russian menu consist russian page-title name")
    @Story(value = "Choose static menu buttons")
    @Test(dataProvider = "subMenuGoodsStaticName")
    public void ruMenuGoodsStaticNameSelectMatchesPage(String subMenuNameAtLink) {
        startPage.open();
        startPage.selectRuLangVersion();
        ruHomePage.selectMainMenu();
        String subMenuBtnLocator = sampleForSubMenuBtnLocator
                .replace("*", subMenuNameAtLink);
        String subMenuName = driver.findElement(By.cssSelector(subMenuBtnLocator)).getText().toLowerCase();
        driver.findElement(By.cssSelector(subMenuBtnLocator)).click();
        String pageTitleLocator = sampleForPageTitleLocator
                .replace("*", subMenuNameAtLink);
        String pageTitleName = driver.findElement(By.xpath(pageTitleLocator)).getText().toLowerCase();
        assert (subMenuName.equals(pageTitleName));
    }

    @DataProvider(name = "subMenuGoodsStaticName")
    public Object[][] provider() {
        return new Object[][]{
                {"all"},
                {"new"},
                {"limited-edition"},
                {"lastsize"},
                {"sale"},
                {"accessories"},
                {"week"},
                {"certificates"},
                {"things"}
        };
    }
}