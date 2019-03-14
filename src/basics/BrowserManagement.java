package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManagement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");

		//getSize() -Dimension class object which is height and width of the browser window
		Window window = driver.manage().window();
		
		Dimension size = window.getSize();
		System.out.println("width of the browser window is "+size.getWidth()+" height of the browser window is "+size.getHeight());
		
		//getPosition() - Point class object which is x and y coordinate location of window
		Point position = window.getPosition();
		System.out.println("x = "+position.getX()+" y = "+position.getY());
		
		
		//maxmize()
		window.maximize();
		Thread.sleep(3000);
		
		
		//fullScreen
		window.fullscreen();
		Thread.sleep(3000);
		
		
		//setSize(Dimesion arg)
		window.setSize(new Dimension(550, 350));
		Thread.sleep(3000);
		
		//setPosition(Point arg)
		window.setPosition(new Point(300, 100));
		Thread.sleep(3000);

		driver.close();
		
	}

}
