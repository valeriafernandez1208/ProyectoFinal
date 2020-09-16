package webdriver.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browser) throws Exception {
        switch (browser){
            case "chrome":
                ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                return chromeDriverCreator.createWebDriver();
            case "firefox":
                FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                return firefoxDriverCreator.createWebDriver();
            default:
                throw new Exception("Navegador " + browser + " no soportado");
        }
    }
}
