package seleniumsessions;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunFlipkart_1A {

	
	public static void main(String[] args) throws Exception {
	
		WebDriver driver = null;
		//driver.manage().window().maximize();
		String browserName ="chrome";
		BrowerUtil_1 bu = new BrowerUtil_1();
		bu.lounchBrowser(browserName);
		bu.lounchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		String title=bu.getTitle();
		if(title.contains("Google")) {
			System.out.println("Title is correct :"+title);
		}else
		{
			System.out.println("title getting wrong :"+title);
		}
		String URL=bu.getPageURL();
	
	
		bu.closeBrowser();

	}

}
