package windowhandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");

		String parentID=driver.getWindowHandle();
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://google.com");
		
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
		
		
		
	}

}
