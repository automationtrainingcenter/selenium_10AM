package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarHelper {

	public static void selectDate(WebElement calendar, String date) {
		boolean status = false;
		// locate the rows inside the calendar
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		// iterate over every row and find the cells
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate every cell and get the text
			for (WebElement cell : cells) {
				String dateText = cell.getText();
				if (dateText.equals(date)) {
					// locate an anchor tag in that cell and click on it
					cell.findElement(By.tagName("a")).click();
					status = true;
					break; // it will break cells loop
				}
			}
			if (status == true) {
				break; // it will break rows loop
			}
		}
	}
}
