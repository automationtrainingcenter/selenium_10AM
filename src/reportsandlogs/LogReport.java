package reportsandlogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ScreenshotHelper;

public class LogReport  extends BaseClass{
	WebDriver driver;
	EventFiringWebDriver edriver;
	Listener listener;

	// launch browser
	public void launchBrowserTest() {
		// start the ExtentTest object
		test = report.startTest("launch Browser Test");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		this.edriver = new EventFiringWebDriver(this.driver);
		this.listener = new Listener();
		this.edriver.register(this.listener);
		this.driver = this.edriver;
		driver.get("http://www.srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "launch browser test passed");
		// end the ExtentTest object
		report.endTest(test);
	}

	// login test
	public void loginTest() {
		test = report.startTest("login test");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		test.log(LogStatus.PASS, "login test passed");
		report.endTest(test);
	}

	// role creation test
	public void createRoleTest() {
		test = report.startTest("role creation with valid data");
		driver.findElement(By.cssSelector("a[href*='Roles']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("AnyONeRole");
		WebElement roleType = driver.findElement(By.id("lstRtypeN"));
		Select roleTypeSelect = new Select(roleType);
		roleTypeSelect.selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		String text = driver.switchTo().alert().getText();
		String imgLoc = ScreenshotHelper.alertScreenCapture("screenshots", "role");
		driver.switchTo().alert().accept();
		System.out.println(text);
		test.log(LogStatus.FAIL, "role creation test failed");
		test.log(LogStatus.INFO, "failed test screenshot", test.addScreenCapture(imgLoc));
		report.endTest(test);
	}

	// logout test
	public void logoutTest() {
		test = report.startTest("logout test");
		driver.findElement(By.cssSelector("a[href='home.aspx']")).click();
		test.log(LogStatus.PASS, "logout test passed");
		report.endTest(test);
	}

	// closebrowser
	public void closeBrowserTest() {
		test = report.startTest("closer browser test");
		driver.close();
		test.log(LogStatus.PASS, "close browser test passed");
		report.endTest(test);
	}

	public static void main(String[] args) {
		LogReport obj = new LogReport();
		report = new ExtentReports(".\\reports\\report1.html");
		obj.launchBrowserTest();
		obj.loginTest();
		obj.createRoleTest();
		obj.logoutTest();
		obj.closeBrowserTest();
		report.flush();
		report.close();
	}
}
