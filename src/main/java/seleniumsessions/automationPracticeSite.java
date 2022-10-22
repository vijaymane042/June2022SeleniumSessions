package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class automationPracticeSite {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		Thread.sleep(5000);
		//By printed=By.xpath("//li[text()='Casual Dresses > Printed ']");
		doSearch("li","Casual Dresses > Printed");
		//driver.findElement(By.xpath("//li[text()='Casual Dresses > Printed ']")).click();
//		List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//		System.out.println(searchList.size());
//		for (WebElement e : searchList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.contains(" Printed Chiffon ")) {
//				e.click();
//				break;
//			}
//		}
//		WebElement headerName = driver.findElement(By.tagName("h1"));
//		String headerText = headerName.getText();
//		if (headerText.equals("Printed Chiffon Dress")) {
//			System.out.println(headerText + ": Text is correct and Passed");
//		}
		
		By search=By.id("search_query_top");
		By suggList =By.xpath("//div[@class='ac_results']//li");
		By header=By.tagName("h1");
		//verifyHeaderText(search, "dress", suggList, "Blouse", header, "Blouse");
	}
	public static void doSearch(String tagName,String text) {
		By printed=By.xpath("//"+tagName+"[text()='"+text+" ']");
		getElement(printed).click();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	 public static String doGettext(By locator) {
		String headerText = getElement(locator).getText();
		return headerText;
	}
	 public static void doSendKey(By locator,String value) {
		getElement(locator).sendKeys(value);
	}

	public static void verifyHeaderText(By searchlocator,String sendKeys, By locatorLists,
			String checktext, By headerT, String compareText) throws InterruptedException {
		doSendKey(searchlocator, sendKeys);
		Thread.sleep(8000);
		List<WebElement> searchList = getElements(locatorLists);
		System.out.println(searchList.size());
		for (WebElement e : searchList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(checktext)) {
				e.click();
				break;
			}
		}
		String copyText=getElement(headerT).getText();
		if (copyText.equals(compareText)) {
			System.out.println(copyText + ": Text is correct and Passed");
		}
		else {
			System.out.println("text not matched Failed");
		}
	}
}
