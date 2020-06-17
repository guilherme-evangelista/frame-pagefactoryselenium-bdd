package br.com.guilhermeevangelista.selenium.core.screenshot;

import br.com.guilhermeevangelista.selenium.core.screenshot.impl.RunScreenshot;
import br.com.guilhermeevangelista.selenium.core.screenshot.impl.UntilScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Screenshot {
	public static byte[] take(WebDriver webDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver));
	}
	
	public static byte[] take(WebDriver webDriver, WebElement... elements) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver, elements));
	}
}
