package reportsandlogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsDemo {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	// launch browser
	public void launchBrowserTest() {
		//start the ExtentTest object
		test = report.startTest("launch Browser Test");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "browser launched");
		driver.get("http://www.srssprojects.in");
		test.log(LogStatus.INFO, "navigated to "+driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "launch browser test passed");
		//end the ExtentTest object
		report.endTest(test);
	}

	// login test
	public void loginTest() {
		test = report.startTest("login test");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		test.log(LogStatus.INFO, "username field located and entered value as Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		test.log(LogStatus.INFO, "password field located and entered value as Admin");
		driver.findElement(By.id("login")).click();
		test.log(LogStatus.INFO, "login button located and clicked");
		test.log(LogStatus.PASS, "login test passed");
		report.endTest(test);
	}

	// role creation test
	public void createRoleTest() {
		test = report.startTest("role creation with valid data");
		driver.findElement(By.cssSelector("a[href*='Roles']")).click();
		test.log(LogStatus.INFO, "roles button located and clicked");
		driver.findElement(By.id("btnRoles")).click();
		test.log(LogStatus.INFO, "new role button located and clicked");
		driver.findElement(By.id("txtRname")).sendKeys("AnyONeRole");
		test.log(LogStatus.INFO, "role name field located and entered value as AnyONeRole");
		WebElement roleType = driver.findElement(By.id("lstRtypeN"));
		test.log(LogStatus.INFO, "Role type field located");
		Select roleTypeSelect = new Select(roleType);
		roleTypeSelect.selectByVisibleText("E");
		test.log(LogStatus.INFO, "role type selected as E");
		driver.findElement(By.id("btninsert")).click();
		test.log(LogStatus.INFO, "submit button located and clicked");
		String text = driver.switchTo().alert().getText();
		test.log(LogStatus.INFO, "got an alert with text as "+text);
		driver.switchTo().alert().accept();
		test.log(LogStatus.INFO, "alert accepted");
		System.out.println(text);
		test.log(LogStatus.PASS, "launch browser test passed");
		report.endTest(test);
	}

	// logout test
	public void logoutTest() {
		test = report.startTest("logout test");
		driver.findElement(By.cssSelector("a[href='home.aspx']")).click();
		test.log(LogStatus.INFO, "logout button located and clicked");
		test.log(LogStatus.PASS, "launch browser test passed");
		report.endTest(test);
	}

	// closebrowser
	public void closeBrowserTest() {
		test = report.startTest("closer browser test");
		driver.close();
		test.log(LogStatus.INFO, "browser closed");
		test.log(LogStatus.PASS, "launch browser test passed");
		report.endTest(test);
	}

	public static void main(String[] args) {
		
		ReportsDemo obj = new ReportsDemo();
		obj.report = new ExtentReports(".\\reports\\report.html");
		obj.launchBrowserTest();
		obj.loginTest();
		obj.createRoleTest();
		obj.logoutTest();
		obj.closeBrowserTest();
		obj.report.flush();
		obj.report.close();
	}
}
