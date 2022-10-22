package waitconcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementToBeClickable {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		By tab = By.xpath("//a[text()='Resources']");
		By tab1= By.xpath("//a[text()='Support']");
		WebElement ele=driver.findElement(tab1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
		//waitForElementIsClickableByLocator(tab1,4);
		waitForElementIsClickableByElement(ele, 5);

	}
	
	public static void waitForElementIsClickableByLocator(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();;
	}
	public static void waitForElementIsClickableByElement(WebElement element,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();;
	}

}
