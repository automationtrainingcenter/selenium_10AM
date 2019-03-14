package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("surya");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement(By.xpath(" ")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
}
