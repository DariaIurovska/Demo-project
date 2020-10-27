package test.java.tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.EnHomePage;
import test.java.pages.RuHomePage;
import test.java.pages.StartPage;
import test.java.pages.UaHomePage;

import static org.testng.Assert.assertEquals;

public class LocalizationByStatusOfWebElements extends TestBaseSetUp {

    StartPage startPage;
    UaHomePage uaHomePage;
    RuHomePage ruHomePage;
    EnHomePage enHomePage;

    @BeforeMethod
    public void pageFactory() {
        startPage = new StartPage(driver);
        uaHomePage = new UaHomePage(driver);
        ruHomePage = new RuHomePage(driver);
        enHomePage = new EnHomePage(driver);
    }

    @Epic("Web-site Start menu")
    @Feature("Elements of Ukrainian web-site version")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find out if Start menu can select correct Ukrainian web-site version by checking status of UA language-header element")
    @Story(value = "Choose ukrainian language button")
    @Test
    public void testUaLangByStatusOfLangHeader() {
        startPage.open();
        startPage.selectUaLangVersion();
        String langHeaderActiveText = uaHomePage.findLangHeaderActiveText().getAttribute("innerHTML").toLowerCase();
        assertEquals(langHeaderActiveText, "ukr");
    }

    @Epic("Web-site Start menu")
    @Feature("Elements of Russian web-site version")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find out if Start menu can select correct Russian web-site version by checking status of RU language-header element")
    @Story(value = "Choose russian language button")
    @Test
    public void testRuLangByStatusOfLangHeader() {

        startPage.open();
        startPage.selectRuLangVersion();
        String langHeaderActiveText = ruHomePage.findLangHeaderActiveText().getAttribute("innerHTML").toLowerCase();
        assertEquals(langHeaderActiveText, "ru");
    }

    @Epic("Web-site Start menu")
    @Feature("Elements of English web-site version")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find out if Start menu can select correct English web-site version by checking status of EN language-header element")
    @Story(value = "Choose english language button")
    @Test
    public void testEnLangByStatusOfLangHeader() {
        startPage.open();
        startPage.selectEnLangVersion();
        String langHeaderActiveText = enHomePage.findLangHeaderActiveText().getAttribute("innerHTML").toLowerCase();
        assertEquals(langHeaderActiveText, "en");
    }
}