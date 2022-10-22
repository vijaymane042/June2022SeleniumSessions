package windowhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerUsingList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(3000);
		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign Up']"));
		signUp.click();
		Thread.sleep(2000);
		
		//Set to List
		Set<String> handlers= driver.getWindowHandles();
		
		List<String> listHandler= new ArrayList<String>(handlers);
		
		String parenet=listHandler.get(0);
		System.out.println("Parent window id is :"+parenet);
		
		String child=listHandler.get(1);
		System.out.println("Parent window id is :"+child);
		
		//switching
		driver.switchTo().window(child);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("first_name")).sendKeys("ABC");
		driver.close();
		
		driver.switchTo().window(parenet);
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
