package testngsessions;


import org.testng.annotations.Test;


public class TestNGConcept {
//Global pre conditions
//pre conditions
//test steps
	//data
	//assert--actual vs expected
	//status
//post steps
	//TtestNG execution hierarchy
	/**
	 * 
	 */
//	@BeforeSuite
//	public void connectWithDB() {
//		System.out.println("@BeforeSuite----connectWithDB");
//	}
//	@BeforeTest
//	public void createTestUser() {
//		System.out.println("@BeforeTest----createTestUser");
//	}
//	@BeforeClass
//	public void lounchBrowser() {
//		System.out.println("@BeforeClass----lounchBrowser");
//	}
//	@BeforeMethod
//	public void login(){
//		System.out.println("@BeforeMethod----login to browser");
//	}
	@Test
	public void searchTest() {
		System.out.println("Test-----Search test");
	}
	@Test(priority = 1)
	public void addToCartTest() {
		System.out.println("Test---add to cart test");
	}
	@Test
	public void paymentTest() {
		System.out.println("Test----payment test method");
	}
//	@AfterMethod
//	public void logout() {
//		System.out.println("@AfterMethod-----logout");
//	}
//	@AfterClass
//	public void closeBrowser() {
//		System.out.println("@AfterClass-----closeBrowser");
//	}
//	@AfterTest
//	public void deleteUser() {
//		System.out.println("@AfterTest-----deleteUser");
//	}
//	@AfterSuite
//	public void closeDBConnection() {
//		System.out.println("@AfterSuite-----closeDBConnection");
//	}
//	
}
