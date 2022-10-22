package testFlipkartApp;

import java.awt.Window;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fpElementUtil {
	private WebDriver driver;

	public fpElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value,Keys.ENTER);
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String getAttributeText(By locator, String value) {
		return getElement(locator).getAttribute(value);
	}

	public  boolean doElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
		 
		
		
		
	}
	
	
}
