package handleActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		// WebElement rightClick=driver.findElement(By.xpath("//span[text()='right click
		// me']"));
		driver.findElements(By.xpath("//ul[contains(@class,'context-menu-list')]//span"));
		// Actions act=new Actions(driver);
		//act.contextClick(rightClick).build().perform();
//		for(WebElement e: rightClickList) {
//			String text=e.getText();
//			System.out.println(text);
//		}
		By rightClick = By.xpath("//span[text()='right click me']");
		By rightClickList = By.xpath("//ul[contains(@class,'context-menu-list')]//span");
		doRightClick(rightClick);
		doRightClickGetText(rightClickList);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void doRightClick(By locator) {
		Actions act = new Actions(driver);
		//act.moveToElement(getElement(locator)).contextClick().build().perform();
		act.contextClick(getElement(locator)).build().perform();
	}

	public static void doRightClickGetText(By locator) {
		Actions act=new Actions(driver);
		for(WebElement e: getElements(locator)) {
			String text=e.getText();
			System.out.println(text);
			if(text.contains("Copy")) {
				e.click();
				break;
			}
	}
	}
}
