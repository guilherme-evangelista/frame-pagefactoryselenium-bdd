package com.example.core.screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.example.core.screenshot.impl.RunScreenshot;
import com.example.core.screenshot.impl.UntilScreenShot;


public class Screenshot {
	public static byte[] take(WebDriver webDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver));
	}
	
	public static byte[] take(WebDriver webDriver, WebElement... elements) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver, elements));
	}
}
