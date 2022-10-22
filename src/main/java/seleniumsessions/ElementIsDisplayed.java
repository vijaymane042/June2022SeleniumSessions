package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementIsDisplayed {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
 
		BrowerUtil_1 brUtil = new BrowerUtil_1();
		driver = brUtil.lounchBrowser("chrome");
		driver.manage().window().maximize();
		brUtil.lounchURL("https:\\www.amazon.com");
//		boolean flag=driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
//		if(flag) {
//			System.out.println("Pass");
//		}
//		else {
//			System.out.println("fail");
//		}
		By serachField=By.id("twotabsearchtextbox");
		
		if(doElementIsDisplayed(serachField)) {
			System.out.println("Element is visible");
			doSendKeys(serachField, "Sumsung Galaxy");
		
			
		}else {
			System.out.println("Element is not visible");
		}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static boolean doElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
}
