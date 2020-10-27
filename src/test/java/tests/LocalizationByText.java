package test.java.tests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.pages.StartPage;
import test.java.pages.UaHomePage;

public class LocalizationByText extends TestBaseSetUp {

    StartPage startPage;

    @BeforeMethod
    public void pageFactory() {
        startPage = new StartPage(driver);
    }

    @Epic("Web-site Start menu")
    @Feature("Ukrainian web-site version")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will find out if Start menu can select correct Ukrainian web-site version by finding keyword at page bottom text")
    @Story(value = "Choose ukrainian language button")
    @Parameters({"uaWord"})
    @Test
    public void testUaLangByText(@Optional("ї") String uaWord) {
        startPage.open();
        startPage.selectUaLangVersion();
        String uaLangBottomText = startPage.findBottomText();
        assert (uaLangBottomText.contains(uaWord));
    }

    @Epic("Web-site Start menu")
    @Feature("Russian web-site version")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will find out if Start menu can select correct Russian web-site version by finding keyword at page bottom text")
    @Story(value = "Choose russian language button")
    @Parameters({"ruWord"})
    @Test
    public void testRuLangByText(@Optional("ы") String ruWord) {
        startPage.open();
        startPage.selectRuLangVersion();
        String ruLangBottomText = startPage.findBottomText();
        assert (ruLangBottomText.contains(ruWord));
    }

    @Epic("Web-site Start menu")
    @Feature("English web-site version")
    @Severity(SeverityLevel.CRITICAL)
    @Description("In this test we will find out if Start menu can select correct English web-site version by finding keyword at page bottom text")
    @Story(value = "Choose english language button")
    @Parameters({"enWord"})
    @Test
    public void testEnLangByText(@Optional("w") String enWord) {
        startPage.open();
        startPage.selectEnLangVersion();
        String enLangBottomText = startPage.findBottomText();
        assert (enLangBottomText.contains(enWord));
    }
}
