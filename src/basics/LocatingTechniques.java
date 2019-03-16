package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {

	public static void main(String[] args) {
		// set system property
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create an object of ChromeDriver class
		WebDriver driver = new ChromeDriver();
		// navigate to url
		driver.get("http://www.facebook.com");

		/*
		 * findElement() -> is used to locate an element in the web page using locator
		 * information. If the element is not located using the given locator info this
		 * method throws NoSuchElementException.
		 */

		/*
		 * findElements() -> is used to locate multiple elements in the web page using
		 * locator information. This method returns a list of elements. if no element is
		 * not located then this method returns an empty list.
		 */

		// selenium provides 8 ways to locate elements in By class all the methods are
		// static methods
		// id -> By.id() locates element uniquely using id attribute of the element
//		By id = By.id("email");
//		WebElement username = driver.findElement(id);
		WebElement username = driver.findElement(By.id("email"));

		// name -> By.name() locates element uniquely using name attribute of the
		// element
		WebElement firstName = driver.findElement(By.name("firstname"));

		// linkText -> By.linkText() locates links(anchor tags) with text of the link
		WebElement forgottenAccount = driver.findElement(By.linkText("Forgotten account?"));

		// partialLinkText -> By.partialLinkText() locates links(anchor tags) with
		// partial text of the link
		WebElement yDateOfBirth = driver.findElement(By.partialLinkText("date of birth"));

		// cssSelector -> By.cssSelector() locates element using css selector of the
		// element
		WebElement mobileNumber = driver
				.findElement(By.cssSelector("input[aria-label='Mobile number or email address']"));

		// xpath -> By.xpath() locates element using xpath(XML path) of the element
		// syntax to xpath is //tagname[@attName = 'attValue' ]
		WebElement password = driver.findElement(By.xpath("//input[@autocomplete='new-password']"));

		// className -> By.className() locates element using class name the of the
		// element
		List<WebElement> inputFileds = driver.findElements(By.className("inputtext"));
		System.out.println("number of input text fields are " + inputFileds.size());

		// tagName -> By.tagName() locates element by it's tag name
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("number of links in the page are " + links.size());

		/*
		 * There is a high probability of locating multiple elements by using class name
		 * and tag name
		 */
		driver.close();
	}

}
