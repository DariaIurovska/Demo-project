package test.java.tests;

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

    @Test
    public void testUaLangByStatusOfLangHeader() {
        startPage.open();
        startPage.selectUaLangVersion();
        String langHeaderActiveText = uaHomePage.findLangHeaderActiveText().getAttribute("innerHTML").toLowerCase();
        assertEquals(langHeaderActiveText, "ukr");
    }

    @Test
    public void testRuLangByStatusOfLangHeader() {

        startPage.open();
        startPage.selectRuLangVersion();
        String langHeaderActiveText = ruHomePage.findLangHeaderActiveText().getAttribute("innerHTML").toLowerCase();
        assertEquals(langHeaderActiveText, "ru");
    }

    @Test
    public void testEnLangByStatusOfLangHeader() {
        startPage.open();
        startPage.selectEnLangVersion();
        String langHeaderActiveText = enHomePage.findLangHeaderActiveText().getAttribute("innerHTML").toLowerCase();
        assertEquals(langHeaderActiveText, "en");
    }
}