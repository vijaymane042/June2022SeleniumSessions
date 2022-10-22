package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class footerLinks {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
//		List<WebElement> footer=driver.findElements(By.xpath("//div[@class='footer-container']//div//a"));
//		System.out.println(footer.size());
//		for(WebElement e : footer) {
//			String str=e.getText();
//			if(str.length()!=0) {
//			System.out.println(str);
//			}
//		}
		footerLinks gt= new footerLinks();
		By footerList=By.xpath("//div[@class='footer-container']//div//a");
		ArrayList<String> getLinks= gt.getFooterLinksText(footerList);
		if(getLinks.contains("About us"));
		{
			System.out.println("Pass");
		}
	}
	
	public List<WebElement> getElements(By locator) {
		return  driver.findElements(locator);
	}
	
	public ArrayList<String> getFooterLinksText(By locator) {
		List<WebElement> footerText = getElements(locator);
		ArrayList<String> footerLinks= new ArrayList<String>();
		System.out.println(footerText.size());
		for(WebElement e : footerText) {
			String str=e.getText();
			footerLinks.add(str);
			if(str.length()!=0) {
			System.out.println(str);
			}
		}
		return footerLinks;
	}

}
