package javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class BringElementToView extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://amazon.in");
		WebElement footerLink = driver.findElement(By.id("navFooter"));
		sleep(2000);
		
		//create JavaScriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView()", footerLink);
		sleep(3000);
		
		closeBrowser();
		
	}
	

}
