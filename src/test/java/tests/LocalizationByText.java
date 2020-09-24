package test.java.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.java.pages.HomePage;

public class LocalizationByText extends TestBaseSetUp {

    HomePage homePage;

    @BeforeMethod

    public void pageFactory() {

        homePage = new HomePage(driver);
    }

    @Parameters({"uaWord"})
    @Test

    public void testUaLangByText(@Optional("ї") String uaWord) {
        homePage.open();
        homePage.selectUaLangVersion();
        String uaLangBottomText = homePage.findBottomText();
        assert (uaLangBottomText.contains(uaWord));
    }

    @Parameters({"ruWord"})
    @Test

    public void testRuLangByText(@Optional("ы") String ruWord) {
        homePage.open();
        homePage.selectRuLangVersion();
        String ruLangBottomText = homePage.findBottomText();
        assert (ruLangBottomText.contains(ruWord));
    }

    @Parameters({"enWord"})
    @Test

    public void testEnLangByText(@Optional("w") String enWord) {
        homePage.open();
        homePage.selectEnLangVersion();
        String enLangBottomText = homePage.findBottomText();
        assert (enLangBottomText.contains(enWord));
    }
}
