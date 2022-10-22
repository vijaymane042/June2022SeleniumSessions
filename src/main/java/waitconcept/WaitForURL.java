package waitconcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumsessions.ElementUtil;

public class WaitForURL {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		//driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]")).click();
		By link=By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]");
		ElementUtil ele= new ElementUtil(driver);
		String handles=driver.getWindowHandle();
		driver.switchTo().window(handles);
		ele.waitForElementVisible(link, 10).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//		if(wait.until(ExpectedConditions.urlContains("opensource-demo.orangehrm"))) {
//			System.out.println(driver.getCurrentUrl());
//		}
		
		//String text=waitForURLContains(10, "opensource-demo.orangehrm");
		String text=waitForURLIs(10, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(text);
		
	}
	
	public static String waitForURLContains(int timeouts,String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}else
		{
			return null;
		}
	}

	public static String waitForURLIs(int timeouts,String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		if(wait.until(ExpectedConditions.urlToBe(urlFraction))) {
			return driver.getCurrentUrl();
		}else
		{
			return null;
		}
	}
}
