package javascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class ScrollBySomeValue extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");

		// locate mouse hover element
		WebElement mouseOverEle = driver.findElement(By.id("mousehover"));

		// bring mouser Hover element into the view
		// create JavaScriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", mouseOverEle);
		sleep(2000);
		js.executeScript("document.documentElement.scrollBy(0, -100)");
		sleep(2000);

		// create Actions class object
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseOverEle).build().perform();
		sleep(3000);
		closeBrowser();
	}

}
