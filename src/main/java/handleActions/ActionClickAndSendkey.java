package handleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClickAndSendkey {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		WebElement key=driver.findElement(By.id("input-firstname"));
//		WebElement checkbox=driver.findElement(By.name("agree"));
//		Actions act= new Actions(driver);
//		act.sendKeys(key, "ABC").build().perform();
//		act.click(checkbox).build().perform();
		
		By key=By.id("input-firstname");
		By checkbox=By.name("agree");
		doActionsSendkeys(key, "Vijay");
		doActionsClick(checkbox);		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doActionsSendkeys(By locator,String text) {
		Actions act= new Actions(driver);
		act.sendKeys(getElement(locator), text).build().perform();
	}
	public static void doActionsClick(By locator) {
		Actions act= new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}

}
