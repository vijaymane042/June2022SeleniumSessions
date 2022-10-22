package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumException {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		// Find WebElement + Perform Action
		// driver.findElement(By.name("search11")).sendKeys("Macbook");
		// thrown NoSuchElementException

		// find WebElemnt and Perform Action
//		WebElement search = driver.findElement(By.name("search11"));
//		search.sendKeys("Macbook");
//
		List<WebElement> links = driver.findElements(By.name("search"));
		System.out.println(links.size());
		// return empty list
		//1.
		if(links.size()==1) {
			System.out.println("Element is present");
		}else
		{
			System.out.println("Element is not present");
		}
		//2.

//		boolean flag = driver.findElement(By.name("search")).isDisplayed();
//		if(flag) {
//			System.out.println("Search element is present on the page");
//		}else {
//			System.out.println("Search element is not present on the page");
//		}
	}

	public static boolean isSingleElementPresent(By locator) {
		List<WebElement> links = driver.findElements(locator);
		System.out.println(links.size());
		if(links.size()==1) {
			System.out.println("Element is present");
			return true;
		}else
		{
			System.out.println("Element is not present");
			return false;
		}
	}
}
