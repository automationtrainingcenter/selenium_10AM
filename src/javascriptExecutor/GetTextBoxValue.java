package javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class GetTextBoxValue extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.facebook.com/");
		
		//locate first name field
		WebElement firstName = driver.findElement(By.name("firstname"));
		
		//send some data to the first name field
//		firstName.sendKeys("surya");
		
		//create JavaScriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]", firstName, "prakash");
		sleep(3000);
		String text = js.executeScript("return arguments[0].value", firstName).toString();
		System.out.println(text);
		closeBrowser();
	}

}
