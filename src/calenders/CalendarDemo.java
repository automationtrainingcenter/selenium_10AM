package calenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
import utilities.CalendarHelper;

public class CalendarDemo extends BrowserHelper {
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.makemytrip.com");
		sleep(4000);
		// locate element which will open calendar and click on it
		driver.findElement(By.id("hp-widget__depart")).click();
		sleep(2000);
		// locate calendar table body
		WebElement dapartCalendar = driver.findElement(By.cssSelector(".dateFilter .ui-datepicker-group-last tbody"));
		CalendarHelper.selectDate(dapartCalendar, "17");
		sleep(3000);

		// locate element which will open return journey calendar and click on it
		driver.findElement(By.id("hp-widget__return")).click();

		// locate return calendar table body
		WebElement returnCalendar = driver
				.findElement(By.cssSelector(".dateFilterReturn .ui-datepicker-group-first tbody"));
		CalendarHelper.selectDate(returnCalendar, "24");
		sleep(3000);
		closeBrowser();
	}
}
