package test.java.tests;

import io.qameta.allure.*;
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

    @Epic("Web-site Start menu")
    @Feature("Elements of Ukrainian web-site version")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find out if Start menu can select correct Ukrainian web-site version by checking active language-header element's color")
    @Story(value = "Choose ukrainian language button")
    @Test
    public void testUaLangByColorOfLangHeader() {
        startPage.open();
        startPage.selectUaLangVersion();
        String actualTextColor = uaHomePage.findLangHeaderActiveText().getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        assertEquals(actualTextColor, expectedTextColor);

    }

    @Epic("Web-site Start menu")
    @Feature("Elements of Russian web-site version")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find out if Start menu can select correct Russian web-site version by checking active language-header element's color")
    @Story(value = "Choose russian language button")
    @Test
    public void testRuLangByColorOfLangHeader() {
        startPage.open();
        startPage.selectRuLangVersion();
        String actualTextColor = ruHomePage.findLangHeaderActiveText().getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        assertEquals(actualTextColor, expectedTextColor);

    }

    @Epic("Web-site Start menu")
    @Feature("Elements of English web-site version")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will find out if Start menu can select correct English web-site version by checking active language-header element's color")
    @Story(value = "Choose english language button")
    @Test
    public void testEnLangByColorOfLangHeader() {
        startPage.open();
        startPage.selectEnLangVersion();
        String actualTextColor = enHomePage.findLangHeaderActiveText().getCssValue("color");
        String expectedTextColor = "rgba(255, 255, 255, 1)";
        assertEquals(actualTextColor, expectedTextColor);

    }

}
