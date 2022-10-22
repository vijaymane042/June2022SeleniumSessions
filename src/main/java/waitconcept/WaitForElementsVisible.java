package waitconcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementsVisible {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		By footer = By.cssSelector("div.footer-nav a");
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		List<WebElement> list=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
		List<WebElement> footerList=WaitForElementTobeVisible(footer, 10);
		for(WebElement e:footerList) {
			System.out.println(e.getText());
		}
	}

	public static List<WebElement> WaitForElementTobeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
