package waitconcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;
	private static final String ELEMENT_NOT_FOUND_ERROR="ELEMENT IS NOT VISIBLE ON THE PAGE: ";

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		By footer = By.xpath("//a[text()='Support']");

		//FluentWait(C)-->implements-->Wait(I)
//	  Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
//			                    .withTimeout(Duration.ofSeconds(10))
//			                         .pollingEvery(Duration.ofSeconds(2))
//			                             .ignoring(NoSuchElementException.class)
//			                                .withMessage("ELEMENT IS NOT VISIBLE ON THE PAGE: "+footer);
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(footer)).click();
		//--We can use fluent wait all features in WebDriverWait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(footer)).click();
	 WebElement click= waitForElementToBeVisibleWithFluentWait(footer, 10, 1);
	 click.click();
	}

	public static WebElement waitForElementToBeVisibleWithFluentWait(By locator, int timeOut, int pollingTimeOut) {
		 Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				   .pollingEvery(Duration.ofSeconds(pollingTimeOut))
				      .ignoring(NoSuchElementException.class)
				         .withMessage(FluentWaitConcept.ELEMENT_NOT_FOUND_ERROR+locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
}
