package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * In WebDriver interface we have switchTo() which will return TargetLocator
 * interface reference In this TargetLocator we have alert() which will return
 * Alert interface reference
 * In this alert interface we have 
 * accept() - which will click on OK button of the alert
 * dismiss() - which will click on Cancel button of the alert
 * getText() - return text of the alert as a String value
 * sendKeys(String arg) - send some data to the text field of alert
 */

public class AlertDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// click on button which will give alert
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		// get the text of alert
		System.out.println("alert came with alert text " + alert.getText());
		// accept the alert
		alert.accept();
		

		driver.findElement(By.id("name")).sendKeys("selenium");
		Thread.sleep(2000);

		// locate confirm button which will give an alert with ok and cancel button and
		// click on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		
		//swtich the driver focus to alert get the alert text
		Alert confrimAlert = driver.switchTo().alert();
		System.out.println("confirm alert came with alert text "+confrimAlert.getText());
		
		//click on cancel button of the alert using dismiss()
		confrimAlert.dismiss();
		Thread.sleep(2000);
		
		driver.close();

	}
}
