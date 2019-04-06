package screenshots;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

/*
 * To capture the alert screenshots Java provides Robot class
 */
public class AlertScreenShotDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		driver.findElement(By.id("alertbtn")).click();
		sleep(3000);
		//create an object of Robot class
		
//		try {
//			Robot r = new Robot();
//			Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
//			BufferedImage bi = r.createScreenCapture(new Rectangle(size));
//			File destImg = new File(getFilePath("screenshots", "alertImage.png"));
//			ImageIO.write(bi, "png", destImg);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ScreenshotHelper.alertScreenCapture("screenshots", "alert");
		driver.switchTo().alert().accept();
		closeBrowser();
	}

}
