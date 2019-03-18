package basics;
/*
 * In WebDriver interface we have switchTo() which will return TargetLocator
 * interface reference In this TargetLocator we have
 * frame(int index) switch frame based on index number of the frame
 * frame(String id/name) switch to frame based on id or name attribute value of the frame
 * frame(WebElement iframe_element) switch to frame based on locating iframe using any
 * attribute value
 * parentFrame() switch to parent frame from a child frame
 * defaultContent() switch to main page from any frame
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn.letskodeit.com/p/practice");
		
		//locate an element in main page and automate it
		driver.findElement(By.id("name")).sendKeys("surya");
		Thread.sleep(3000);
		
		//switch to frame using it's id
		driver.switchTo().frame("courses-iframe");
		
		//locate an element inside the frame and automate it
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(3000);
		
		//switch back to the main page
		driver.switchTo().defaultContent();
		
		//locate an element in main page and automate is
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Thread.sleep(3000);
		
		
		driver.close();
		
		
		
		
		
	}

}
