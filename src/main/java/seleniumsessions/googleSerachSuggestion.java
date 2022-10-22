package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSerachSuggestion {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		//driver.findElement(By.name("q")).sendKeys("Selenium");
		By search = By.name("q");
		By googleSuggList = By.xpath("//div[@class='wM6W7d']/span");
		//doSendKeys(search, "selenium");
		
		ArrayList<String> listtext=googleSearch(search,"Selenium",googleSuggList,"selenium testing");
		System.out.println(listtext);

//	List<WebElement> suggList = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
//	System.out.println(suggList.size()-1);
//	
//	for(WebElement e : suggList) {
//		String str = e.getText();
//		System.out.println(str);
//		if(str.equals("selenium java"))
//		{
//			e.click();
//			break;
//		}
//	}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
    public static ArrayList<String> googleSearch(By searchLocator,String senKeyValue,By locator,String value) throws InterruptedException {
    	doSendKeys(searchLocator, senKeyValue);
    	Thread.sleep(4000);
    	List<WebElement> allSuggList=getElements(locator);
    	ArrayList<String> listText =new ArrayList<String>();
    	for(WebElement e : allSuggList) {
    		String str = e.getText();
    		if(str.equals(value)) {
    			e.click();
    			break;
    		}
    		listText.add(str);
    	}
    	return listText;
    }
}
