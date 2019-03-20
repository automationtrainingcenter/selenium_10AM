package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class NSEIndia extends BrowserHelper {
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		String companyCode = "TITAN";
		//locate table body
		WebElement tbody = driver.findElement(By.cssSelector("#preOpenNiftyTab>tbody"));
		//locate all the rows inside the table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		//iterate every row and find cells
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate over the cell and get the text of every cell
			try {
				if(cells.get(0).getText().equals(companyCode)) {
					System.out.println(cells.get(3).getText());
					break;
				}
			} catch (Exception e) {
				
			}
		}
		closeBrowser();
	}
}
