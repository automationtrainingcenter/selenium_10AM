package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

/*To automate mouse and keyboard events
 * Selenium provides Actions class
 * In this Actions we have several methods to automate mouse and keyboard related events
 * 
 */

public class MouseHoverDemo extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "http://amazon.in");

		// locate shop by category
		WebElement shopByCat = driver.findElement(By.id("nav-link-shopall"));
		// create an object of Actions class
		Actions actions = new Actions(driver);

		// moveToElement() is used to move mouse to some elemnet
		actions.moveToElement(shopByCat).build().perform();
		sleep(1000);
		//locate mobile and computers
		WebElement mobileAndComputer = driver.findElement(By.xpath("//span[contains(text(),'Mobiles, Computers')]"));
		actions.moveToElement(mobileAndComputer).build().perform();
		sleep(1000);
		
		//locate power banks
		WebElement powerBanks = driver.findElement(By.xpath("//span[contains(text(),'Power Banks')]"));
		actions.moveToElement(powerBanks).click().build().perform();
		sleep(3000);
		closeBrowser();
		
	}

}
