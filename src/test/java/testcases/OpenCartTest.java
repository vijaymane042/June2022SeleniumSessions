package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{

	@Test
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OpenCart - Open Source Shopping Cart Solution");
	}

	@Test(priority = 1)
	public void logoTest() {
		Assert.assertTrue(driver.findElement(By.cssSelector("a.navbar-brand")).isDisplayed());
	}

}
