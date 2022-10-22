package waitconcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		 //Explicit wait: there are two types of Explicit wait
		   //..it is applied for a specific element, not for all the element
		   //..not a global wait
		   //..can be used for non web elements--title, URL, alerts
           //1. Web driver wait
           //2. Fluent Wait
		
		//WebDriverWait(C)--> extends--> fluentWait(C)--> implements--> Wait(I)--> until();
		//fluentWait(C)--> until() -->override + other methods
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By username=By.id("input-email");
		By password=By.id("input-password");
		By logo=By.className("img-responsive");
		By headerName= By.xpath("//h2[text()='New Customer']");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement userNM=wait.until(ExpectedConditions.presenceOfElementLocated(username));
//		userNM.sendKeys("ABC");
//		
//		driver.findElement(password).sendKeys("ABC");
		waitForElementPresence(username, 10).sendKeys("Vijay");
		getElement(password).sendKeys("ABC");
		
		if(waitForElementPresence(logo, 5).isDisplayed()) {
			System.out.println("Logo is present");
		}
		
		doSendKeysWithWait(password, 5, "Mane");
		String headerText=getElementWithWait(headerName, 10);
		System.out.println(headerText);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	//An expectation for checking that an element is present on the DOM of a page.
	//This does not necessarily mean that the element is visible.
	public static WebElement waitForElementPresence(By locator, int timeouts) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	/*
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 */
	public static WebElement waitForElementVisible(By locator, int timeouts) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}
	
	public static void doSendKeysWithWait(By locator, int timeouts , String text) {
		waitForElementPresence(locator, timeouts).sendKeys(text);
	}
	public void doClickWithWait(By locator, int timeouts) {
		waitForElementPresence(locator, timeouts).click();
	}
	
	public static String getElementWithWait(By locator, int timeouts) {
		return waitForElementPresence(locator, timeouts).getText();
	}
}
