package calenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class AutoSuggestions extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.google.com");
		// locate search field and enter some data
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		sleep(2000);
		
		//locate that suggestion box i.e UL tag
		WebElement suggestionBox = driver.findElement(By.className("erkvQe"));
		
		//locate all suggestions which are in that suggestion box i.e Li tags
		List<WebElement> suggestions = suggestionBox.findElements(By.tagName("li"));
		//iterate over every suggestion
		for(WebElement suggestion : suggestions) {
			if(suggestion.getText().equals("selenium webdriver architecture")) {
				suggestion.click();
				break;
			}
		}
		sleep(3000);
		closeBrowser();
		

	}

}
