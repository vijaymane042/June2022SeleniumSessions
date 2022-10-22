package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementsSectionList {
static WebDriver driver;
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
//		List<WebElement> sectionLinks =driver.findElements(By.className("list-group-item"));
//		System.out.println(sectionLinks.size());
//		for (WebElement e : sectionLinks) {
//			System.out.println(e.getText());
//		}
		
		By links =By.className("list-group-item");
		ElementUtil util = new ElementUtil(driver);
		ArrayList<String> printText=util.getElementsTextList(links);
		System.out.println(printText);
		if(printText.contains("Address Book")) {
			System.out.println("Passed");
		}
		
	}

}
