package testFlipkartApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrickBuzz {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/");
		
    By matches=By.xpath("//div[@class='ds-text-compact-xxs']");
    By summary = By.xpath("//div[@class='ds-shrink-0']/a");
    By team = By.xpath("//div[@class='ds-mt-3']//table//tbody/tr");
    getFindMatch(matches,"INDIA");
    Thread.sleep(20000);
    driver.findElement(By.id("wzrk-cancel")).click();
    getFindMatch(summary,"Squads");
    Thread.sleep(4000);
    getFindMatch(team,"Zeeshan Ali");
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void getFindMatch(By locator,String value) throws InterruptedException {
		List<WebElement> totalMatches=getElements(locator);
		Thread.sleep(3000);
		//ArrayList<String> text = new ArrayList<String>();
		for(WebElement e: totalMatches) {
			 String text1=e.getText();
			System.out.println(text1);
			System.out.println("---------------------");
			//text.add(text1);
			if(text1.contains(value)) {
				e.click();
				break;
			}
			
		}
		
	}


}
