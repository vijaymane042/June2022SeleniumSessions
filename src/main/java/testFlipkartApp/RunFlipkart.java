package testFlipkartApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumsessions.BrowerUtil_1;
import seleniumsessions.ElementUtil;

public class RunFlipkart {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		FlipkartBrowserUtil brUtil = new FlipkartBrowserUtil();
		driver = brUtil.lounchBrowser("chrome");
		driver.manage().window().maximize();
		brUtil.lounchFlipkarURL("https://www.flipkart.com");
		String getT=brUtil.getFlipkartTitle();
		System.out.println(getT);
 
		fpElementUtil elUtil = new fpElementUtil(driver);
		By closePopUp = By.className("_2doB4z");
		By serach = By.className("_3704LK");
		By selectProduct = By.linkText("Contact Us");
		By gettext = By.className("z3ht-w");
		By btnVisible = By.className("_1_3w1N");
		By addToChart = By.className("YUhWwv");
		
		elUtil.doClick(closePopUp);
		elUtil.doSendKeys(serach, "mobile");
		String test =elUtil.getAttributeText(selectProduct, "href");
		System.out.println(test);
		String printText=elUtil.doGetText(gettext);
		System.out.println(printText);
		boolean flag=elUtil.doElementIsDisplayed(btnVisible);
		if(flag) {
			System.out.println("Visible");
		}else
		{
			System.out.println("In visible");
		}	   
		
		elUtil.doClick(addToChart);
	}
	public static WebElement getElement(By locator) {
		 return driver.findElement(locator);
	}
	public static void doSendKeys(By locator , String value) {
		getElement(locator).sendKeys(value);	
	}
}
