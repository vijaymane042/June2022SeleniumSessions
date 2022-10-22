package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
static WebDriver driver;
	public static void main(String[] args) {
		String browserName= "chrome";
		System.out.println("Browser is opening...." + browserName);		
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https:\\www.google.com");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https:\\www.google.com");
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https:\\www.google.com");
			break;

		default:
			System.out.println("Browser is invlid");
			break;
		}
		
		
		String title = driver.getTitle();
		if (title.contains("Online"))
		{
			System.out.println("Flipkart opened successfully...!!!!!!");
		}
		else
	    {
			System.out.println("Invalid URL...");
		}
        
	}

}
