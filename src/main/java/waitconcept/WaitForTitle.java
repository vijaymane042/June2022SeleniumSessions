package waitconcept;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freework.com/home");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.titleIs("Freework - The solution for project-based organizations"))) {
//			System.out.println(driver.getTitle());
//		}
//		if(wait.until(ExpectedConditions.titleContains("for project-based organizations"))){
//			System.out.println(driver.getTitle());
//		}
//		Boolean flag = wait.until(ExpectedConditions.titleContains("for project-based organizations"));
//		if (flag) {
//			System.out.println(driver.getTitle());
//		}
		
//		String title=waitForTitleContains(2, "for project-based organizations");
//		System.out.println(title);
		
		String title=waitForTitles(2, "Freework - The solution for project-based organizations");
		System.out.println(title);
	}
	
	public static String waitForTitleContains(int timeouts, String titleFraction) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		if(wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}else {
			return null;
		}
	}
	
	public static String waitForTitles(int timeouts, String titleFraction) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		if(wait.until(ExpectedConditions.titleIs(titleFraction))) {
			return driver.getTitle();
		}else {
			return null;
		}
	}

}
