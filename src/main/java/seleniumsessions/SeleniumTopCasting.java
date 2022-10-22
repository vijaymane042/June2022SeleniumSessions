package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTopCasting {

	public static void main(String[] args) {
	
		//ChromeDriver driver = new ChromeDriver();// valid
		
		//WebDriver driver = new WebDriver();//not valid
		//WebDriver driver = new ChromeDriver();// valid
		
		//SearchContext driver = new ChromeDriver(); // valid but not useful
		
		//RemoteWebDriver driver = new ChromeDriver();// valid and useful
		
		//ChromiumDriver driver = new ChromeDriver();//
		
		//WebDriver driver = new RemoteWebDriver(new URL(""),capabilities);
		
		//SearchContext driver = new RemoteWebDriver();		
		
		
		
		

	}

}
