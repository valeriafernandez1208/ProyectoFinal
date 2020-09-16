package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogonPage extends BasePage {
    private By alertLogon = By.id("flash");
    private By btnLogout = By.xpath("//a[@class='button secondary radius']");
    public LogonPage(WebDriver driver) {
        super(driver);
    }
    public String lblAlertLogon (){
        String getTextalert=driver.findElement(alertLogon).getText();
        return getTextalert;
    }
    public AuthPage clicBtnLogout (){
        driver.findElement(btnLogout).click();
        return new AuthPage(driver);
    }
}
