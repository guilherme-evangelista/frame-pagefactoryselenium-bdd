package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    protected static WebDriver webDriver ;
    protected static WebDriverWait wait;
    private static PropertiesManager propertiesManager = new PropertiesManager();

    protected static void initDriver(WebApplication webApplication){
        webDriver = webApplication.getDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 10);
        webDriver.get(propertiesManager.getProp("urlAPP"));
    }

    protected static void closeDriver() {
        webDriver.quit();
    }
}
