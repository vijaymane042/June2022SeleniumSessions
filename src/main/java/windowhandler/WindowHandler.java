package windowhandler;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign Up']"));
		signUp.click();
		Set<String> handlers = driver.getWindowHandles();
		Iterator<String> iter = handlers.iterator();
		String parentWindowId = iter.next();
		System.out.println("Parent Windiw Id is :" + parentWindowId);
		
		String childWindowId = iter.next();
		System.out.println("Child Windiw Id is :" + childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("first_name")).sendKeys("ABC");
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
