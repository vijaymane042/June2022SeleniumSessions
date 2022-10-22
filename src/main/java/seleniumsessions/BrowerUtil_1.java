package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowerUtil_1 {

	private WebDriver driver;

	/**
	 * this method is used to initialize the driver on the basis of browser name
	 * @param browserName
	 */
	public WebDriver lounchBrowser(String browserName) {
		System.out.println("Browser is opening...." + browserName);
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Browser is invlid");
			break;
		}
		return driver;

	}

	/**
	 * this method is used to to launch the URL on the basic of URL
	 * @param URL
	 * @throws Exception
	 */
	public void lounchURL(String URL) throws Exception {
		if(URL.length() == 0) {
			System.out.println("URl is blank");
			throw new Exception("INVALIDEXCEPTION");
		}
			else if (URL.indexOf("http")!=0 && URL.indexOf("https")!=0 ){
			System.out.println("URL doesn't contains http or https, please enter correct URL :" + URL);
			throw new Exception("INVALID_URL_EXCEPTION");
			
		} else {
			System.out.println();
			driver.get(URL);
		}
		
	}

	/**
	 * this method is used to verify the page title
	 * @return
	 */
	public String getTitle() {
		String title = driver.getTitle();
		System.out.println("page title :"+title);
		if(title != null)
		{
		return title;
		}
		else
		{
			System.out.println("getting null title...");
			return null;
			
		}
	}
	
	/**
	 * this method is used to verify the Page URL
	 * @return
	 */
	public String getPageURL() {
	 String getPageURL= driver.getCurrentUrl();	
	 System.out.println("Current URL :"+getPageURL);
	 if(getPageURL != null) {
		 return getPageURL;
	 }
	 else
	 {
		 System.out.println("getting null URL");
		 return null;
	 }
	}

	/**
	 * this method is used to Close the browser
	 */
	public void closeBrowser() {
		if(driver!= null) {
		driver.close();
		System.out.println("Browser is closed.............");
		}
	}
	
	public void quiteBrowser() {
		if(driver!= null) {
		driver.quit();
		System.out.println("Browser is closed.............");
		}
	}
}
