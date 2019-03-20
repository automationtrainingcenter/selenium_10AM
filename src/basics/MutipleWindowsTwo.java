package basics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MutipleWindowsTwo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/nivedita/selenium_concepts/frames/framesDemo.html#");
		driver.manage().window().maximize();

		// now driver focus is in main window
		// locate open windows button in main window and click on it, it will open
		// multiple windows
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);
		// get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		//automate youtube window
		for(String windowHanlde : windowHandles) {
			String title = driver.switchTo().window(windowHanlde).getTitle();
			if(title.equalsIgnoreCase("youtube")) {
				driver.findElement(By.id("search")).sendKeys("selneium"+Keys.ENTER);
				Thread.sleep(3000);
				
				break;
			}else {
				driver.close();
			}
		}
		
		driver.quit();
	}
}
