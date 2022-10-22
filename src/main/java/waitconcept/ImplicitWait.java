package waitconcept;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//Implicit wait
		//1. It is define as a global wait
		//2. it will be applied on all the web elements by default
		//3. Applied after the driver declaration
		//4. not recommended
		//5. it does not supports non web element--title, URL, alerts
		/*
		 * We never use implicitlyWait in framework design
		 */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//login page: applied 10 sec
		//e1 = 5 sec --> 10-5=5 (5 sec will be ignored)
		//e2 = 3 sec --> 10-3=7 (7 sec will be ignored)
		
		//home page--5 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//every time you need to set wait using implicitlyWait
		
		
		
	

	}

}
