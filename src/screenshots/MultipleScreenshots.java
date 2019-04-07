package screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;
import utilities.ScreenshotHelper;

public class MultipleScreenshots extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://amazon.in");
		sleep(3000);
		int height = driver.findElement(By.id("nav-main")).getSize().getHeight();
		//find the view height(client height) of the web page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long cHeight = (long) js.executeScript("return document.documentElement.clientHeight")-height;
		//find the total page height (scroll height)
		long sHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
		System.out.println("scroll height is "+sHeight+" client height is "+cHeight);
		while(sHeight > 0) {
			//capture the screenshot of the page
			ScreenshotHelper.captureScreenShot(driver, "screenshots", "amazon");
			//scroll the page by client height
			JavaScriptHelper.scrollPage(driver, 0, (int)cHeight);
			sleep(2000);
			sHeight -= cHeight;
		}
		closeBrowser();
		
	}
}
