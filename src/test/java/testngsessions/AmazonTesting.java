package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTesting {
	static WebDriver driver;
	@BeforeMethod
	public void lounchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		String title=driver.getTitle();
		//Assert.assertEquals(true, true);
	}
    @Test(priority=2)
	public void serachTest() {
		boolean flag=driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		Assert.assertEquals(true, true);
	}
    @Test
    public void titleTest() {
    	String title=driver.getTitle();
    	System.out.println(title);
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }
    @Test(priority=1)
    public void logoTest() {
    	Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
    }
    @AfterMethod
    public void tearDown() {
    	driver.close();
    }
}