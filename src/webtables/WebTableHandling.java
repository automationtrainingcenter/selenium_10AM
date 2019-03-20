package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class WebTableHandling extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		//locate table body
		WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));
		//locate all the rows inside the table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		//iterate every row and find cells
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate over the cell and get the text of every cell
			for(WebElement cell : cells) {
				System.out.print(cell.getText()+"\t");
			}
			System.out.println();
		}
		closeBrowser();
	}

}
