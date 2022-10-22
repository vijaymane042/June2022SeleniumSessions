package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestWithDataDriven {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
	}
	@DataProvider
	public Object[][] getNegativeLoginData() {
		return new Object[][] {{"abc@gmai.com","password"},
			                   {"   ","   "},
			                   {"","test2123"},
			                   {"test@gamil","@@@$$@$"},
			                   {"234q34#","  "}
		};
	}
	@Test(dataProvider = "getNegativeLoginData")
	public void loginNegativeTest(String username, String Password) {
		Assert.assertTrue(dologin(username,Password));
	}
	public boolean dologin(String username, String Password) {
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText());
	return driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).isDisplayed();
	}
}
