package waitconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	static WebDriver driver;
	private static final String ELEMENT_NOT_FOUND_ERROR = "ELEMENT IS NOT VISIBLE ON THE PAGE: ";

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		By footer = By.xpath("//a[text()='Support']123");
		//retryingElement(footer, 10);
		//retryingElement(footer, 10).click();
		//retryingElement(footer, 2, 2).click();
		try {
		retryingElement(footer, 2, 2).click();
		throw new Exception("ELEMENTNOTFOUND");
		}catch(Exception e) {
			System.out.println("Element is not found... tried for");
		}
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement retryingElement(By locator, int timeOut) {
		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				System.out.println("Element is found at: " + attempts + " attempt");
				break;
			} catch (Exception e) {
				System.out.println("Element not is found in attempts: " + attempts + " : " + "for" + locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempts++;
		}
		if (element == null) {
			System.out.println(
					"Element is not found expection...tried for: " + timeOut + "secs " + "with the interval of " + 500+ " ms");
		}
		return element;
	}
	
	public static WebElement retryingElement(By locator, int timeOut, int pollingTime) {
		int attempts=0;
		WebElement element=null;
		
		while(attempts < timeOut) {
			
			try {
			element=getElement(locator);
			System.out.println("Element is found in "+attempts+" attempt");
			break;
			}catch(Exception e) {
				System.out.println("Element not fount in attempts "+attempts+" : "+" for "+timeOut+" secs.");
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element==null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
				
			}catch(Exception e)
			{
				System.out.println("Element is not found... tried for "+timeOut+ "secs " + " With the interval of "+pollingTime+" ms");
			}
		}
		return element;
	}
	
	
	
}
