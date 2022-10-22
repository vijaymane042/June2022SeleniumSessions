package waitconcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitIntervalTime {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		By youtubeLink = By.xpath("//div[@class='orangehrm-login-footer-sm']/a[4]");
		//tried for 10 second(s) with 500 milliseconds interval
		//Default time of wait is 500 milliseconds interval-tried for 10 second(s) with 500 milliseconds interval
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		////Polling time of custom wait  is 3000 milliseconds interval-tried for 10 second(s) with 3000 milliseconds interval
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(3));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(youtubeLink)).click();
		WaitForElementVisible(youtubeLink, 10, 1);
	}

	public static void WaitForElementVisible(By locator,int timeouts, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts), Duration.ofSeconds(pollingTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}
}
