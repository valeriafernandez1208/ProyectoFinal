package Tests;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ReportManager;
import webdriver.factory.WebDriverFactory;

public abstract class BaseTest {
    protected WebDriver webDriver;
    private String URL="https://the-internet.herokuapp.com/";

    @BeforeSuite
    public static void setUpSuite() throws Exception {
        ReportManager.init("C:\\Reports", "LoginSite");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser, ITestResult iTestResult) throws Exception {
        webDriver = WebDriverFactory.getDriver(browser);
        webDriver.get(URL);
        webDriver.manage().window().maximize();
        ReportManager.getInstance().startTest(iTestResult.getMethod().getMethodName());

    }


    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if(iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null){
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.FAIL, "Failure Image");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(webDriver != null)
                webDriver.quit();
        }
    }

    @AfterSuite
    public static void tearDownSuite(){
        ReportManager.getInstance().flush();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(webDriver != null)
            webDriver.quit();
    }


}
