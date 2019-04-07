package sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.BrowserHelper;

public class SikuliDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		//create Pattern class objects
		Pattern chrome = new Pattern(getFilePath("images", "chrome.PNG"));
		Pattern address = new Pattern(getFilePath("images", "address.PNG"));
		Pattern search = new Pattern(getFilePath("images", "search.PNG"));
		Pattern searchButton = new Pattern(getFilePath("images", "searchButton.PNG"));
		
		//create Screen class object
		Screen screen = new Screen();
		
		try {
			screen.find(chrome);
			screen.click(chrome);
			sleep(3000);
			screen.find(address);
			screen.type(address, "http://www.google.com"+Key.ENTER);
			sleep(3000);
			screen.find(search);
			screen.type(search, "selenium");
			sleep(3000);
			screen.find(searchButton);
			screen.click(searchButton);
			sleep(3000);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
		
	}

}
