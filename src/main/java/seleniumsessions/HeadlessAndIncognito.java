package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessAndIncognito {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		//options.setHeadless(true);
//		options.addArguments("--headless");
//		options.addArguments("--incognito");
//		WebDriver driver = new  ChromeDriver(options);
//		driver.get("https://www.google.co.in/");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		driver.quit();
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo = new FirefoxOptions();
		//options.setHeadless(true);
		//fo.addArguments("--headless");
		fo.addArguments("-private");
		WebDriver driver = new  FirefoxDriver(fo);
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.quit();
		
//		WebDriverManager.edgedriver().setup();
//		EdgeOptions eo = new EdgeOptions();
//		//options.setHeadless(true);
//		//fo.addArguments("--headless");
//		eo.addArguments("-InPrivate");
//		WebDriver driver = new  EdgeDriver(eo);
//		driver.get("https://www.google.co.in/");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		//driver.quit();
	}

}
