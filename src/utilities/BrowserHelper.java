package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {

	protected static WebDriver driver;

	public static void launchBrowser(String browserName, String url) {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("windows")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
				driver = new FirefoxDriver();
			}
		} else{
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver"));
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver"));
				driver = new FirefoxDriver();
			}
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}
	
	public static void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeBrowser() {
		if(driver.getWindowHandles().size() == 1) {
			driver.close();
		}else {
			driver.quit();
		}
	}

//	public static void main(String[] args) {
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(getFilePath("drivers", "chromedriver.exe"));
//	}

}
