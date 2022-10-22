package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumsessions.BrowerUtil_1;

public class BaseTest {

 WebDriver driver;
 
    @Parameters({"url","browser"})
	@BeforeTest
	public void lounchBrowser(String url, String browser) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
    	BrowerUtil_1 br = new BrowerUtil_1();
    	driver=br.lounchBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		String title=driver.getTitle();
		//Assert.assertEquals(true, true);
	}
	@AfterTest
    public void tearDown() {
    	driver.close();
    }
}
