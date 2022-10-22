package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

	
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
    
}
