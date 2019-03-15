package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize the browser window
		driver.manage().window().maximize();

		// navigate to the url using to(String arg) of Navigation interface
		Navigation navigate = driver.navigate();
		navigate.to("http://www.google.com");
		Thread.sleep(3000);
		// navigate to another URl using to(URL arg)
		navigate.to(new URL("http://www.facebook.com"));
//		Thread.sleep(3000);

		// navigate back in driver history
		navigate.back();
		Thread.sleep(3000);

		// navigate forward in driver history
		navigate.forward();
		Thread.sleep(3000);

		// refresh the current web page
		navigate.refresh();
		Thread.sleep(3000);
		
		driver.close();

	}

}
