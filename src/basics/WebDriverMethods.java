package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {
	
	public static void main(String[] args) throws InterruptedException {
		//set System property for chromedriver.exe file path
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		//create an object of the browser driver class to launch the browser
		WebDriver driver = new ChromeDriver();
		
		//navigate to a url
		driver.get("http://www.google.com");
		Thread.sleep(2000);
		
		//getTitle() String Value which is title of the webpage
		String title = driver.getTitle();
		System.out.println("title of the web page is "+title);
		
		//getCurrentUrl() return url of the current web page as String value
		String url = driver.getCurrentUrl();
		System.out.println("url of the current page is "+url);
		
		//getPageSource() returns complete source code of the webpage as a string value
		String pageSource = driver.getPageSource();
		System.out.println("page source contains exptected text "+pageSource.contains("Facebook helps you connect and share with the people in your life"));

		
		//getWindowHandle() returns unique id of the current browser window
		String windowHandle = driver.getWindowHandle();
		System.out.println("current browser window id is "+windowHandle);
		
		//getWindowHanles() returns a set of string values which are ids of the windows opened by driver instance
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("number of windows opened are " + windowHandles.size());
		
		//findElement(By arg) return a WebElement interface reference
		WebElement email = driver.findElement(By.name("q"));
		
		
		//findElements(By arg) returns a list of elements of type WebElement
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("number of links in the page are "+links.size());
		
		//close the browser
		driver.close();
		
		//quit() which will closes all the browser windows
		driver.quit();
	}
	
	

}
