package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		//locate open window button in main window and click on it. It will open another window
		driver.findElement(By.id("opentab")).click();
		
		//get all window ids using getWindowHandles() of WebDriver interface
		Set<String> windowHandles = driver.getWindowHandles();
		//convert set to list
		List<String> windowsIds = new ArrayList<>(windowHandles);
		/*
		 * In index 0 of list we have parent window id, index 1 contains first child window id
		 * index 2 contains second child window id and so on
		 */
		//now driver focus is in main window and switch that focus to child window
		driver.switchTo().window(windowsIds.get(1));
		//now driver foucs switched to child window
		//locate element in child window and automate is
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(3000);
		//switch the driver focus back to parent window
		driver.switchTo().window(windowsIds.get(0));
		//locate enter your name element in main window and automate it
		driver.findElement(By.id("name")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.quit();
		
	}

}
