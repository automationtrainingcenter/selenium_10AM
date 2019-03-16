package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		//locate the list box
		WebElement fruits = driver.findElement(By.id("multiple-select-example"));
		//create Select class object
		Select fruitSelect = new Select(fruits);
		
		//get all available options of list box
		List<WebElement> options = fruitSelect.getOptions();
		System.out.println("the number of options are "+options.size());
		
		//select an option based on index
		fruitSelect.selectByIndex(1); //orange
		Thread.sleep(2000);
		
		//select an option based value attribute value
		fruitSelect.selectByValue("peach");
		Thread.sleep(2000);
		
		//select an option based on inner text of the element
		fruitSelect.selectByVisibleText("Apple");
		Thread.sleep(2000);
		
		//get all the selected options of a list box
		List<WebElement> selectedOptions = fruitSelect.getAllSelectedOptions();
		System.out.println(selectedOptions.size());
		
//		//deselect all the options
//		fruitSelect.deselectAll();
//		Thread.sleep(3000);
		
		//deselect an option based on index
		fruitSelect.deselectByIndex(2);
		Thread.sleep(2000);
		
		//deselect an option based on value
		fruitSelect.deselectByValue("apple");
		Thread.sleep(2000);
		
		//deselect an option based on visible text
		fruitSelect.deselectByVisibleText("Orange");
		Thread.sleep(2000);
		
		driver.close();
		
	}

}
