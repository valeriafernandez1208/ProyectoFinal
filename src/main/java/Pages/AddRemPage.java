package Pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class AddRemPage extends BasePage {
    private By addElement  = By.cssSelector("button");
    private By removeElement = By.cssSelector("added-manually");
    public AddRemPage(WebDriver driver) {
        super(driver);
    }
    public void btnAddRemoveElement(){
        driver.findElement(addElement).click();
        WebDriverWait wait=new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(removeElement)));
        driver.findElement(removeElement).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.INFO, "Login");
        //File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        /*try {
            FileUtils.copyFile(myScreenShot, new File("screenshots/ScreenAddRemove"+System.currentTimeMillis()+".png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/

    }
}
