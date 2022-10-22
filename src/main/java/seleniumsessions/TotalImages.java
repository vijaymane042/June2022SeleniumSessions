package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https:\\www.amazon.com");
		// Web Scraping concept
//		List<WebElement> imgCount = driver.findElements(By.tagName("img"));
//		System.out.println(imgCount.size());
//      
//		for(WebElement e : imgCount) {
//		String altValue = e.getAttribute("alt");
//		String srcValue = e.getAttribute("src");
//		
//		System.out.println(altValue + " : " + srcValue);
//		}

		By images = By.tagName("img");
		By links = By.tagName("a");

//		System.out.println(getElemets(images).size());
//		System.out.println(getElemets(links).size());
		
//		int imageSize = getListSize(images);
//		System.out.println(imageSize);
//		if (imageSize < 200) {
//			System.out.println("PASS");
//		}
//		
//		int totalLinks = getListSize(links);
//		System.out.println(getListSize(links));
//		if (totalLinks > 200) {
//			System.out.println("PASS");
//		}
		//ArrayList<String> finalList=getElementsTextList(links);
		//System.out.println(finalList);
		ArrayList<String> finalImgaeList=getElementsAttributeTextList(images,"src");
		System.out.println(finalImgaeList);
		

	}

	public static List<WebElement> getElemets(By locator) {
		return driver.findElements(locator);
	}

	public static int getListSize(By locator) {
		return getElemets(locator).size();
	}
	
	public static ArrayList<String> getElementsTextList(By locator) {
	List<WebElement> elementList = getElemets(locator);
	//List<String> totalText = new ArrayList<String>();
	ArrayList<String> totalText = new ArrayList<String>();
	for (WebElement e : elementList) {
		String text= e.getText();
		totalText.add(text);
	}
	return totalText;
	}
	
	public static ArrayList<String> getElementsAttributeTextList(By locator, String value) {
		List<WebElement> attributeElementList = getElemets(locator);
		//List<String> totalText = new ArrayList<String>();
		ArrayList<String> totalAttributeText = new ArrayList<String>();
		for (WebElement e : attributeElementList) {
			String text= e.getAttribute(value);
			totalAttributeText.add(text);
		}
		return totalAttributeText;
		}
}
