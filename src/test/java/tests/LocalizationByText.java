package test.java.tests;

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

    @Parameters({"uaWord"})
    @Test
    public void testUaLangByText(@Optional("ї") String uaWord) {
        startPage.open();
        startPage.selectUaLangVersion();
        String uaLangBottomText = startPage.findBottomText();
        assert (uaLangBottomText.contains(uaWord));
    }

    @Parameters({"ruWord"})
    @Test
    public void testRuLangByText(@Optional("ы") String ruWord) {
        startPage.open();
        startPage.selectRuLangVersion();
        String ruLangBottomText = startPage.findBottomText();
        assert (ruLangBottomText.contains(ruWord));
    }

    @Parameters({"enWord"})
    @Test
    public void testEnLangByText(@Optional("w") String enWord) {
        startPage.open();
        startPage.selectEnLangVersion();
        String enLangBottomText = startPage.findBottomText();
        assert (enLangBottomText.contains(enWord));
    }
}
