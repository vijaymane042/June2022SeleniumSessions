package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandling {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		/**
		 * Create web element + perform action ( sendkeys, close, click, IsDisplayed,
		 * gettext )
		 * 
		 */
		// 1st approach
//       driver.findElement(By.id("input-firstname")).sendKeys("Vijay");
//       driver.findElement(By.id("input-lastname")).sendKeys("Mane");
//       driver.findElement(By.id("input-email")).sendKeys("Vijaymane@gmail.com");
//       driver.findElement(By.id("input-telephone")).sendKeys("5645132112");
//       driver.findElement(By.id("input-password")).sendKeys("Vijay@123");
//       driver.findElement(By.id("input-confirm")).sendKeys("Vijay@123");

		// 2nd approach
//         WebElement firstName = driver.findElement(By.id("input-firstname"));
//       WebElement lastName = driver.findElement(By.id("input-lastname"));
//       WebElement email = driver.findElement(By.id("input-email"));
//       WebElement telePhone = driver.findElement(By.id("input-telephone"));
//       WebElement password = driver.findElement(By.id("input-password"));
//       WebElement confirmPWD = driver.findElement(By.id("input-confirm"));
//         firstName.sendKeys("Vijay");
//       lastName.sendKeys("Mane");
//       email.sendKeys("Vijaymane@gmail.com");
//       telePhone.sendKeys("5645132112");
//       password.sendKeys("Vijay@123");
//       confirmPWD.sendKeys("Vijay@123");

		// 3rd approach
//		By firstName = By.id("input-firstname");	
//		By lastName = By.id("input-lastname");
//		By email = By.id("input-email");
//		By telePhone = By.id("input-telephone");
//		By password = By.id("input-password");
//		By confirmPWD = By.id("input-confirm");
//		WebElement fName = driver.findElement(firstName);
//		WebElement lName = driver.findElement(lastName);
//		WebElement emailID = driver.findElement(email);
//		WebElement phone = driver.findElement(telePhone);
//		WebElement pwd = driver.findElement(password);
//		WebElement cfmpwd = driver.findElement(confirmPWD);
//		fName.sendKeys("Vijay");
//		lName.sendKeys("Mane");
//		emailID.sendKeys("Vijaymane@gmail.com");
//		pwd.sendKeys("Vijay@123");
//		cfmpwd.sendKeys("Vijay@123");

		//  approach using By class
//       By firstName= By.id("input-firstname");
//       By lastName= By.id("input-lastname");
//       By email= By.id("input-email");
//       By telePhone= By.id("input-telephone");
//       By password= By.id("input-password");
//       By confirmPWD= By.id("input-confirm");
//       driver.findElement(firstName).sendKeys("Vijay");
//       driver.findElement(lastName).sendKeys("Mane");   
//       driver.findElement(email).sendKeys("Vijaymane@gmail.com");
//       driver.findElement(telePhone).sendKeys("5645132112");
//       driver.findElement(password).sendKeys("Vijay@123");
//       driver.findElement(confirmPWD).sendKeys("Vijay@123");
		
		// 4th by locator + generic functions
//		By firstName = By.id("input-firstname");	
//		By lastName = By.id("input-lastname");
//		By email = By.id("input-email");
//		By telePhone = By.id("input-telephone");
//		By password = By.id("input-password");
//		By confirmPWD = By.id("input-confirm");
//		getElement(firstName).sendKeys("Vijay");
//		getElement(firstName).sendKeys("Vijay");
//		getElement(lastName).sendKeys("Mane");
//		getElement(email).sendKeys("Vijaymane@gmaail.com");
//		getElement(telePhone).sendKeys("5645132112");
//		getElement(password).sendKeys("Vijay@123");
//		getElement(confirmPWD).sendKeys("Vijay@123");
		
		//5th approach
		//by locator + get element + perform generic action
//		By firstName = By.id("input-firstname");		
//		By lastName = By.id("input-lastname");
//		By email = By.id("input-email");
//		By telePhone = By.id("input-telephone");
//		By password = By.id("input-password");
//		By confirmPWD = By.id("input-confirm");
//		doSendKeys(firstName, "Vijay");		
//		doSendKeys(lastName, "Mane");
//		doSendKeys(email, "Vijaymane@gmail.com");
//		doSendKeys(telePhone, "1231321312312");
//		doSendKeys(password, "Vijay@123");
//		doSendKeys(confirmPWD, "Vijay@123");
		
		//6th approach
		//by locator + element util class + perform generic function
//		By firstName = By.id("input-firstname");
//		By lastName = By.id("input-lastname");
//		By email = By.id("input-email");
//		By telePhone = By.id("input-telephone");
//		By password = By.id("input-password");
//		By confirmPWD = By.id("input-confirm");
//		ElementUtil util = new ElementUtil(driver);
//		util.doSendKeys(firstName, "Vijay");
//		util.doSendKeys(lastName, "Mane");
//		util.doSendKeys(email, "Vijaymane@gmail.com");
//		util.doSendKeys(telePhone, "122152112");
//		util.doSendKeys(password, "Vijay@123");
//		util.doSendKeys(confirmPWD, "Vijay@123");
	}
//4th approach
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}
	public static void doSendKeys(By locator , String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	
	public static void click(By locator) {
		getElement(locator).click();
	}
	
	

}
