package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTestWithDataDriven {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	}
	
	@DataProvider
	public Object[][] setNegativeTestData() {
		return new Object[][]{{"ram","ram","ram165@gmail.com","123456759","12365"},
			                  {"shyam","shyam","shyam156@gmail.com","12345655759","123456"},
			                  {"jhon","jhon","jhon145@gmail.com","1245656759","12344"}
		};
	}
	
	@Test(dataProvider = "setNegativeTestData")
	public void loginTest(String firstName, String lastName, String gmaiID, String telephone, String password) throws InterruptedException {
		Assert.assertEquals(doLoginTest(firstName,lastName,gmaiID,telephone,password),"Your Account Has Been Created!");
	}
	public String doLoginTest(String firstName, String lastName, String gmaiID, String telephone, String password) throws InterruptedException {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(gmaiID);
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String title=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		System.out.println(title);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']")).click();
		String logout=driver.findElement(By.xpath("//h1[text()='Account Logout']")).getText();
		System.out.println(logout);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Register']")).click();
		return title;
		
		
	}
}
