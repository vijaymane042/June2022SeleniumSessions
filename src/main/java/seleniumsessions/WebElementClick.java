package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementClick {
  
	static WebDriver driver;
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
//		driver.findElement(By.id("username")).sendKeys("a@gmail.com");
//		driver.findElement(By.id("password")).sendKeys("Vijay@12");
//		driver.findElement(By.id("loginBtn")).click();
 
		By userNM=By.id("username");
		By pwd=By.id("password");
		By LoginButton=By.id("loginBtn");
		doSendKeys(userNM, "a@gmail.com");
		doSendKeys(pwd, "Vijay@12");
		doClick(LoginButton);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doClick(By locator) {
		getElement(locator).click();
	}
}
