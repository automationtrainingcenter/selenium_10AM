package mouseandkeyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class SliderDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.hdfc.com/home-loan-emi-calculator");
		//locate slider head
		WebElement sliderHead = driver.findElement(By.cssSelector("#js-rangeslider-2>.rangeslider__handle"));
		
		//locate the slider
		WebElement slider = driver.findElement(By.id("js-rangeslider-2"));
		//find slider width
		int width = slider.getSize().getWidth();
		System.out.println(width);
		int move = (int)(width * 0.06);
		//create Actions class object
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(sliderHead, move, 0).build().perform();
		sleep(3000);
		actions.dragAndDropBy(sliderHead, -80, 0).build().perform();
		sleep(3000);
		closeBrowser();
		
	}

}
