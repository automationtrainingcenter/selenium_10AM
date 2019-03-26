package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class NSEIndiaClick extends BrowserHelper {
	public static void main(String[] args) {
		launchBrowser("chrome", "https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		String companyCode = "LT";
		//locate table body
		WebElement tbody = driver.findElement(By.cssSelector("#preOpenNiftyTab>tbody"));
		//locate all the rows inside the table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		//iterate every row and find cells
		for(int i = 2; i<rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// iterate over the cell and get the text of every cell
			try {
				if(cells.get(0).getText().equals(companyCode)) {
					WebElement link = cells.get(0).findElement(By.tagName("a"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView()", link);
					link.click();
					sleep(3000);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		closeBrowser();
	}
}
