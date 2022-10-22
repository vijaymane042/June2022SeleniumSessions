package handleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("http://automationpractice.com/index.php");
		//driver.get("https://www.spicejet.com/");
		driver.get("https://www.bigbasket.com/");
		

//		Actions act= new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//a[text()='Women']"))).build().perform();
//		Thread.sleep(3000);
//        driver.findElement(By.linkText("Blouses")).click();
		By level1 = By.xpath("//a[text()='Women']");
		By level2=By.linkText("Blouses");
		By addOns=By.xpath("//div[text()='Add-ons']");
		By canceYou1st=By.linkText("You-1st");
		
		By category=By.xpath("//a[@class='dropdown-toggle meganav-shop']");
		By subMenu1=By.xpath("//a[text()='Fresh Vegetables']");
		By subMenu2=By.linkText("Cucumber & Capsicum");
		By subMenu3=By.xpath("");
		//handleLevelMenuItems(level1, level2);
		//handleLevelMenuItems(addOns, canceYou1st);
		handleLevelMenuItems(category, subMenu1,subMenu2);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void handleLevelMenuItems(By parentMenu, By childMenu1 , By childMenu2) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).build().perform();
		Thread.sleep(3000);
		act.moveToElement(getElement(childMenu1)).build().perform();
		Thread.sleep(3000);
		//act.moveToElement(getElement(childMenu2)).build().perform();
		Thread.sleep(3000);
		getElement(childMenu2).click();
	}
}
