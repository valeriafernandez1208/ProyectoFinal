package Tests;

import Pages.AddRemPage;
import Pages.HomePage;
import org.testng.annotations.Test;

@Test
public class AddRemoveTest extends BaseTest {
    public void TestAddRemove () throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        Thread.sleep(5000);
        homePage.clicLinkAddRem();
        Thread.sleep(5000);
        AddRemPage addRemPage = new AddRemPage(webDriver);
        Thread.sleep(5000);
        addRemPage.btnAddRemoveElement();
    }

}
