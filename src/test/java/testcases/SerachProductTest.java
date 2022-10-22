package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SerachProductTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/search");
	}
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {{"mac"},
			                   {"iphone"},
			                   {"samsung"}
	                          };
	}
	
	@Test(dataProvider = "productData")
	public void searchTest(String product) {
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(product);
		driver.findElement(By.xpath("//span[@class='input-group-btn']/button")).click();
		List<WebElement> searchedProduct=driver.findElements(By.xpath("//div[@class='product-thumb']"));
		System.out.println(searchedProduct.size());
		for(WebElement e: searchedProduct) {
			System.out.println(e.getText());
		}
	}
	
}

