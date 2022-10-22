package handleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle=driver.findElement(By.id("draggable"));
		WebElement destinationEle=driver.findElement(By.id("droppable"));
//		By sourceEle=By.id("draggable");
//		By destinationEle=By.id("droppable");
		
		Actions act= new Actions(driver);
		act.clickAndHold(sourceEle).moveToElement(destinationEle).release().build().perform();
		//act.dragAndDrop(sourceEle, destinationEle).build().perform();
		
	}

}
