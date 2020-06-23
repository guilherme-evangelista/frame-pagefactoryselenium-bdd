package br.com.guilhermeevangelista.selenium.core.driver;

import br.com.guilhermeevangelista.selenium.core.driver.Web;
import br.com.guilhermeevangelista.selenium.core.utils.PropertiesManager;
import br.com.guilhermeevangelista.selenium.core.driver.WebApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        driver = ((WebApplication) Web.CHROME).getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertiesManager.getProp("urlAPP"));
    }

    public static void killDriver() {
        driver.quit();
        driver = null;
    }

}
