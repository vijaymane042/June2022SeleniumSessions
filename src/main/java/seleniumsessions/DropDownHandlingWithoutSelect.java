package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandlingWithoutSelect {

	static WebDriver driver;
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		
	//WebElement country=driver.findElement(By.xpath("//div/select"));
	//country.click();
		
//	List<WebElement> getCountryvalue=driver.findElements(By.xpath("//select[@id='Form_getForm_Country']/option"));
//	System.out.println(getCountryvalue.size());
//	for(WebElement e : getCountryvalue) {	
//		String text=e.getText();
//		System.out.println(text);
//		if(text.equals("India")) {
//			e.click();
//			break;
//		}
//	}
		By country=By.xpath("//select[@id='Form_getForm_Country']/option");
		doSelectDropDownValueWithoutSelect(country, "Japan");

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static void doSelectDropDownValueWithoutSelect(By locator,String value) {
		List<WebElement> countryValue=getElements(locator);
		for(WebElement e : countryValue) {	
			String text=e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
	}
		
	}
}
