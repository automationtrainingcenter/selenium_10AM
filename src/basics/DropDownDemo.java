package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();

		// locate date drop down list
		WebElement date = driver.findElement(By.id("day"));
		Select dateSelect = new Select(date);
		// get the default selected date
		WebElement defaultDate = dateSelect.getFirstSelectedOption();
		System.out.println("default date is " + defaultDate.getText());

		// select a date based on index
		dateSelect.selectByIndex(10);
		Thread.sleep(3000);

		// locate month drop down list
		WebElement month = driver.findElement(By.id("month"));
		Select monthSelect = new Select(month);
		// get the default selected month
		System.out.println("default month is " + monthSelect.getFirstSelectedOption().getText());

		// select month based on value of the value attribute
		monthSelect.selectByValue("9");
		Thread.sleep(2000);

		// locate year drop down list
		WebElement year = driver.findElement(By.id("year"));
		Select yearSelect = new Select(year);
		// get the default selected year
		System.out.println("default year is " + yearSelect.getFirstSelectedOption().getText());

		// select year based on inner text of the option tag
		yearSelect.selectByVisibleText("1990");
		Thread.sleep(3000);

		driver.close();

	}

}
