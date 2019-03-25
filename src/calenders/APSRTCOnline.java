package calenders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
import utilities.CalendarHelper;

public class APSRTCOnline extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://apsrtconline.in/oprs-web/");
		driver.findElement(By.id("txtJourneyDate")).click();
		sleep(2000);
		WebElement departCal = driver.findElement(By.cssSelector(".ui-datepicker-group-first tbody"));
		CalendarHelper.selectDate(departCal, "25");
		sleep(4000);
		driver.findElement(By.id("txtReturnJourneyDate")).click();
		sleep(2000);
		WebElement returnCal = driver.findElement(By.cssSelector(".ui-datepicker-group-first tbody"));
		CalendarHelper.selectDate(returnCal, "29");
		sleep(3000);
		closeBrowser();
	}

}
