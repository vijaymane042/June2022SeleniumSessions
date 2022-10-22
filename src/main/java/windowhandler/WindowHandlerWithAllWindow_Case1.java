package windowhandler;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerWithAllWindow_Case1 {
	static WebDriver driver;
/*
 * IMP interview question 
 * Handle multiple windows without closing the parent window
 */
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		String parentWindowIDs=driver.getWindowHandle();
		System.out.println(parentWindowIDs);
		
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[1]")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[2]")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[3]")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']/a[4]")).click();
		
		Set<String> handers=driver.getWindowHandles();
		Iterator<String> iter=handers.iterator();
		while(iter.hasNext()) {
		String childWindow=iter.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		System.out.println(childWindow);
		if(!childWindow.equals(parentWindowIDs)) {
			driver.close();
		}
		}
		driver.switchTo().window(parentWindowIDs);
	System.out.println(driver.getTitle());	
	}

}
