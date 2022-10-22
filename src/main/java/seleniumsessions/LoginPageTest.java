package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageTest {
   static WebDriver driver;
	public static void main(String[] args) throws Exception {
		BrowerUtil_1 brUtil = new BrowerUtil_1();
		 driver = brUtil.lounchBrowser("chrome");
		driver.manage().window().maximize();
		brUtil.lounchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
	
 
		ElementUtil elUtil = new ElementUtil(driver);
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telePhone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPWD = By.id("input-confirm");
		By continueBTN = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By getText = By.tagName("h1");
		By warningMsgText=By.className("alert");
		
		//driver.findElements(By.className("col-sm-2"));
		By getWarningMsg=(By.className("col-sm-2"));
		elUtil.doSendKeys(firstName, "Vijay");
		elUtil.doSendKeys(lastName, "Mane");
		elUtil.doSendKeys(email, "Vijaymane@gmail.com");
		elUtil.doSendKeys(telePhone, "122152112");
		elUtil.doSendKeys(password, "Vijay@123");
		elUtil.doSendKeys(confirmPWD, "Vijay@123");
		elUtil.doClick(continueBTN);
		String actualText=elUtil.doGetText(getText);
		if(actualText.equals("Register Account")) {
			System.out.println("Text is correct :" +actualText);
		}else {
			System.out.println("text is not valid");
		}
		
		System.out.println(elUtil.doGetText(warningMsgText));
		//List<WebElement> messages=getFindElements(getWarningMsg);
		
		
		
		brUtil.closeBrowser();
	}

//	public static List<WebElement> getFindElements(By locator) {
//	      List<WebElement> allWarningMsg= driver.findElements(locator); 
//	      for (WebElement count : allWarningMsg) {
//	    	 // List<WebElement> getMsg= getMsg.get(count);
//	      }
	//}
}
