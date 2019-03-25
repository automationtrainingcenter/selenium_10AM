package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class DragElementDemo extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/draggable/");
		// switch to frame which contains drag element
		driver.switchTo().frame(0);
		// locate drag element
		WebElement dragEle = driver.findElement(By.id("draggable"));
		// create Actions class object
		Actions actions = new Actions(driver);
//		actions.clickAndHold(dragEle).moveByOffset(250, 150).release().build().perform();
		actions.dragAndDropBy(dragEle, 200, 100).build().perform();
		sleep(3000);
		closeBrowser();
	}

}
