package com.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Web implements WebApplication {
    CHROME{
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            return new ChromeDriver();
        }
    },

    FIREFOX{
        @Override
        public WebDriver getDriver() {
            System.setProperty("webdriver.firefox.driver", "drivers/geckodriver");
            return new FirefoxDriver();
        }
    }
}
