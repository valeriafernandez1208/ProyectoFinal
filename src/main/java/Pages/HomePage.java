package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By linkFormAuth = By.linkText("Form Authentication");
    private By linkAddRem = By.linkText("Add/Remove Elements");
    private By linkCheck = By.linkText("Checkboxes");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public AuthPage clicLinkFormAuth (){
        driver.findElement(linkFormAuth).click();
        return new AuthPage(driver);
    }
    public AddRemPage clicLinkAddRem (){
        driver.findElement(linkAddRem).click();
        return new AddRemPage(driver);
    }
    public CheckPage clicLinkCheck (){
        driver.findElement(linkCheck).click();
        return new CheckPage(driver);
    }
}
