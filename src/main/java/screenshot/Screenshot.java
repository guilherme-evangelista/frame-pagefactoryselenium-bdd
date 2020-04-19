package screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import screenshot.impl.RunScreenshot;
import screenshot.impl.UntilScreenShot;


public class Screenshot {
	public static byte[] take(WebDriver webDriver) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver));
	}
	
	public static byte[] take(WebDriver webDriver, WebElement... elements) {
		return new RunScreenshot().take(UntilScreenShot.screenShotWeb(webDriver, elements));
	}
}
