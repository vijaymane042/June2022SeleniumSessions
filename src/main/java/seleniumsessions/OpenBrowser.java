package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
		

		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\Vijay\\Selenium setup\\chromedriver\\chromedriver_win32\\chromedriver.exe");
	    //System.setProperty("webdriver.gecko.driver", "D:\\Vijay\\Selenium setup\\chromedriver\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.edge.driver", "D:\\Vijay\\Selenium setup\\chromedriver\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.co.in/");
        String url=driver.getCurrentUrl();
        System.out.println("Current URL :"+url);
        String title=driver.getTitle();
        System.out.println("Page title is :"+title);
        if(title.contains("Google"))
        {
        	System.out.println("PASSED");
        }
        else {
        	System.out.println("FAILED");
        }
       
      
	}

}
