package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {


    @Test(priority=2)
	public void serachTest() {
		boolean flag=driver.findElement(By.name("q")).isDisplayed();
		System.out.println(flag);
		Assert.assertEquals(true, true);
	}
    @Test
    public void titleTest() {
    	String title=driver.getTitle();
    	System.out.println(title);
		Assert.assertEquals(title, "Google");
    }
    @Test(priority=1)
    public void logoTest() {
    	Assert.assertTrue(driver.findElement(By.cssSelector("img.lnXdpd")).isDisplayed());
    }
 
}
