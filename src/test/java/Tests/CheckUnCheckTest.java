package Tests;

import Pages.CheckPage;
import Pages.HomePage;
import org.testng.annotations.Test;

public class CheckUnCheckTest extends BaseTest {
    @Test
    public void CheckUnCheck () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clicLinkCheck();
        CheckPage checkPage = new CheckPage(webDriver);
        checkPage.checkUnCheck();
    }

}
