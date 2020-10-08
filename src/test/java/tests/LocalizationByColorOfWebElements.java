package test.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.EnHomePage;
import test.java.pages.RuHomePage;
import test.java.pages.StartPage;
import test.java.pages.UaHomePage;

import static org.testng.Assert.assertEquals;

public class LocalizationByColorOfWebElements extends TestBaseSetUp {

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
    public void testUaLangByColorOfLangHeader() {
        startPage.open();
        startPage.selectUaLangVersion();
        String actualTextColor = uaHomePage.findLangHeaderActiveText().getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        assertEquals(actualTextColor, expectedTextColor);

    }

    @Test
    public void testRuLangByColorOfLangHeader() {
        startPage.open();
        startPage.selectRuLangVersion();
        String actualTextColor = ruHomePage.findLangHeaderActiveText().getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        assertEquals(actualTextColor, expectedTextColor);

    }

    @Test
    public void testEnLangByColorOfLangHeader() {
        startPage.open();
        startPage.selectEnLangVersion();
        String actualTextColor = enHomePage.findLangHeaderActiveText().getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        assertEquals(actualTextColor, expectedTextColor);

    }

}
