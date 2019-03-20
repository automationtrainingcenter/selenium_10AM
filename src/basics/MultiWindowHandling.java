package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/nivedita/selenium_concepts/frames/framesDemo.html#");
		driver.manage().window().maximize();

		// now driver focus is in main window
		// locate open windows button in main window and click on it, it will open
		// multiple windows
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		// get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// convert set to list
		List<String> windowIds = new ArrayList<>(windowHandles);

//		for (int i = 0; i < windowIds.size(); i++) {
//			driver.switchTo().window(windowIds.get(i));
//			System.out.println("window "+i+" title is "+driver.getTitle());
//		}
		
		//automate google page
		//swtich the driver focus to google page
		driver.switchTo().window(windowIds.get(3));
		driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		Thread.sleep(4000);
		
		//automate youtube page
		//switch driver focus to youtube page
		driver.switchTo().window(windowIds.get(2));
		driver.findElement(By.id("search")).sendKeys("selenium"+Keys.ENTER);
		Thread.sleep(3000);
		
		//automate facebook page
		//switch the driver focus first child window
		driver.switchTo().window(windowIds.get(1));
		/*
		 * In TargetLocator interface we have activeElement() which switch driver focus to active 
		 * element in the page
		 */
		driver.switchTo().activeElement().sendKeys("surya");
		Thread.sleep(3000);
		
		//switch the driver focus to main window and click open tabs button
		driver.switchTo().window(windowIds.get(0));
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
