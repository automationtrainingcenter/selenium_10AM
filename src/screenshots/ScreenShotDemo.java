package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

/*
 * To capture the screenshots selenium provides TakeScreenShot interface
 * Create an object reference of this interface by converting WebDriver reference
 */
public class ScreenShotDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File srcImg = ts.getScreenshotAs(OutputType.FILE);
//		File destImg = new File(getFilePath("screenshots", "image1.png"));
//		try {
//			BufferedImage bi = ImageIO.read(srcImg);
//			ImageIO.write(bi, "png", destImg);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ScreenshotHelper.captureScreenShot(driver, "screenshots", "practice");
		closeBrowser();
	}

}
