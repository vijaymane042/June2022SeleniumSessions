package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		BrowerUtil_1 brUtil = new BrowerUtil_1();
		driver = brUtil.lounchBrowser("chrome");
		driver.manage().window().maximize();
		brUtil.lounchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		String getAttValue=driver.findElement(By.id("input-email")).getAttribute("placeholder");
//		System.out.println(getAttValue);
		By emailID = By.id("input-email");
		By regLink = By.linkText("Register");
		By imgLogo = By.className("img-responsive");
		//		emailID.sendKeys("Vijay@Mane");
//		String text=emailID.getAttribute("value");
//		System.out.println(text);
  
		String text1=getAttributeText(emailID, "placeholder");
		String text2=getAttributeText(regLink, "href");
		String text3=getAttributeText(imgLogo, "src");
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static String getAttributeText(By locator, String value) {
	   return getElement(locator).getAttribute(value);
	}

}
