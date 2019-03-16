package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		/*
		 * A web page is a combination of many different HTML elements, like images,
		 * buttons, tables, links, labels, forms, edit boxes, paragraphs, dropdown boxes
		 * and so on, these elements are WebElements in the context of WebDriver.
		 */

		// click -> click() clicks on any element
		WebElement signUpButton = driver.findElement(By.name("websubmit"));
		signUpButton.click();
		Thread.sleep(2000);

		// sendKeys -> sendKeys() fills text box or text area with given value
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("surya");
		Thread.sleep(2000);

		// clear -> clear() clears the text inside the text box or text area
		firstName.clear();
		Thread.sleep(2000);

		// getAttribute -> getAttribute(String arg) returns the value of the given
		// attribute
		String aria_required_Value = firstName.getAttribute("aria-required");
		System.out.println("aria required attribute value of first name is " + aria_required_Value);

		// getCssValue -> getCssValue(String arg) returns the value of the given css
		// property
		String firstNameWidth = firstName.getCssValue("width");
		System.out.println("width of first name text field is " + firstNameWidth);

		// getText -> getText() returns the inner text of the element
		String innerText = signUpButton.getText();
		System.out.println("inner text of the sign up butto is " + innerText);

		// getTagName -> getTagName() return the tag name of the element
		String tagName = signUpButton.getTagName();
		System.out.println("sign up button tag name is " + tagName);

		// getLocation -> getLocation() returns the location of the element as Point
		// class object from the top-left corner of the web page
		Point location = signUpButton.getLocation();
		System.out.println("sign up is at x = " + location.getX() + " at y = " + location.getY());

		// getSize -> getSize() returns the size of the element in terms of width of
		// height as Dimension class object
		Dimension size = signUpButton.getSize();
		System.out
				.println("sign up element width is " + size.getWidth() + "px and height is " + size.getHeight() + "px");

		// isDiplayed -> isDisplayed() returns true if an element is visible on the page
		boolean mobileNum = driver.findElement(By.name("reg_email__")).isDisplayed();
		System.out.println("mobile number or email address is displayed " + mobileNum);

		System.out.println("re enter email address is displayed "
				+ driver.findElement(By.name("reg_email_confirmation__")).isDisplayed());

		// isElabled -> isEnabled() returns true if an element is enabled on the page
		System.out.println("first name field is enabled "+firstName.isEnabled());

		// isSelected -> isSelected() returns true if a radio button or check box or
		// list box or drop down button option is selected right now
		System.out.println("female radio button is selected "+driver.findElement(By.xpath("//input[@value='1']")).isSelected());
		
		// submit -> submit() submit a form to the web server
		driver.findElement(By.name("pass")).submit();
		Thread.sleep(3000);

		driver.close();
	}

}
