package com.example.core;

import com.example.core.utils.PropertiesManager;
import com.example.core.driver.Web;
import com.example.core.driver.WebApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver(Web.CHROME);
        }
        return driver;
    }

    private static void createDriver(WebApplication webApplication) {
        driver = webApplication.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get(PropertiesManager.getProp("urlAPP"));
    }

    public static void killDriver() {
        driver.quit();
        driver = null;
    }
}
