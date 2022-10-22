package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class FindElementsConcept {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		BrowerUtil_1 brUtil = new BrowerUtil_1();
		 driver = brUtil.lounchBrowser("chrome");
		driver.manage().window().maximize();
		brUtil.lounchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println(driver.getTitle());

	}

}
