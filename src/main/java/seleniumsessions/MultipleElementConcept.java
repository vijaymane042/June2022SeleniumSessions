package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleElementConcept {

	static WebDriver driver;
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https:\\www.amazon.com");

		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		int counter = 1;
//		for(int i = 0 ; i<links.size(); i++) {
//		String getLinkText	= links.get(i).getText();
//		
//		if(getLinkText.length()!=0) {
//			System.out.println(counter + " : " +getLinkText);
//			counter++;
//		}
//		}
		
		for ( WebElement getLinkText :  links) {
		String finaltext =	getLinkText.getText();
		if(finaltext.length()!=0) {
			System.out.println(counter + " : " + finaltext);
			counter++;
		}
		String hrefValue= getLinkText.getAttribute("href");
		System.out.println("href :" +hrefValue);
		}
		driver.close();
	}

}
