package sikuli;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.BrowserHelper;

/*Sikuli is a tool to automate GUI using visual image macth. In sikuli all web elements should be
* taken as images and store in project folder.
* Download and install sikuliX from http://sikulix.com.
* Associate sikulixapi.jar file to project build path.
* Capture images of elements using any snipping tool which we want to automate and store in project folder.
*
* Sikuli mainly provides two classes
* Screen -- is the main class which will perform all the operations like type, find, click, wait and so on.
* Pattern -- is used to store the images of elements we want to automate.
*/

public class FileUploadDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		driver.findElement(By.xpath("//div[text()='Choose file']")).click();
		sleep(3000);
		
		//create Pattern class object
		Pattern fileName = new Pattern(getFilePath("images", "fileName.PNG"));
		Pattern openButton = new Pattern(getFilePath("images", "open.png"));
		
		//create Screen class object
		Screen screen = new Screen();
		try {
			screen.find(fileName);
			screen.type(fileName, "D:\\selenium\\Notes\\sikuli.doc");
			screen.find(openButton);
			screen.click(openButton);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		sleep(3000);
		closeBrowser();
	}
	
}
