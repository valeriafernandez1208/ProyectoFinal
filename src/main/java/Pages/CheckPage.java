package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CheckPage extends BasePage {
    private By check1 = By.xpath("//body//input[1]");
    private By check2 = By.xpath("//body//input[2]");
    public CheckPage(WebDriver driver) {
        super(driver);
    }
    public void checkUnCheck(){
        driver.findElement(check1).click();
        driver.findElement(check2).click();
        File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(myScreenShot, new File("screenshots/ScreenCheckTest"+System.currentTimeMillis()+".png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
