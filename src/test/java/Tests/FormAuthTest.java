package Tests;

import Pages.AuthPage;
import Pages.HomePage;
import Pages.LogonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FormAuthTest extends BaseTest {

    @Test
    public void testFormAuth() throws IOException {
        HomePage homePage = new HomePage(webDriver);
        homePage.clicLinkFormAuth();
        AuthPage authPage = new AuthPage(webDriver);
        authPage.Login("tomsmith","SuperSecretPassword!");
        authPage.clicBtnLogin();
        LogonPage logonPage = new LogonPage(webDriver);
        String getTextAlert=logonPage.lblAlertLogon();
        Assert.assertTrue(getTextAlert.contains("You logged into a secure area!"));
        logonPage.clicBtnLogout();
    }

}
