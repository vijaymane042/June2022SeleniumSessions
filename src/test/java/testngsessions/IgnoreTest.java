package testngsessions;

import org.testng.annotations.Test;

public class IgnoreTest {
	@Test(description = "Its testNG project")
	public void searchTest() {
		System.out.println("Test-----Search test");
	}
	@Test(enabled = false)
	public void addToCartTest() {
		System.out.println("Test---add to cart test");
	}
	@Test(enabled = true,description = "Payment method")
	public void paymentTest() {
		System.out.println("Test----payment test method");
	}
	
	@Test(enabled = false)
	public void addToCartTest1() {
		System.out.println("Test---add to cart test");
	}

}
