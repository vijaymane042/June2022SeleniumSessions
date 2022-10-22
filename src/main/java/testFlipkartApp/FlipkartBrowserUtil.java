package testFlipkartApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartBrowserUtil {

	private WebDriver driver;

	public WebDriver lounchBrowser(String browser) {
		System.out.println(browser + " browser is getting lonched... ");
		switch (browser.toLowerCase()) {
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
			System.out.println(browser + " is not valid, kindly pass correct browser to lounch...");
			break;
		}
		return driver;
	}

	public void lounchFlipkarURL(String URL) {
		if (URL != null) {
			driver.get(URL);
		} else {
			System.out.println(URL + "is inlvalid");
		}
	}

	public String getFlipkartTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void closeFlipkartBrowser() {
		driver.close();
	}

	
}
