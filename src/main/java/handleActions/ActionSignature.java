package handleActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionSignature {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cocosign.com/signature-generator/draw/");
	//	driver.findElement(By.xpath("//li[text()='Draw Signature']")).click();
		By signaturePad= By.id("signature-pad");
		WebElement signaturegenerator=driver.findElement(signaturePad);
		Actions act= new Actions(driver);
		Action sign=act.click(signaturegenerator).moveToElement(signaturegenerator, 3, 3)
				.clickAndHold(signaturegenerator)
				.moveByOffset(200,-50)
				.moveByOffset(150,50)
				.moveByOffset(50, -50)
				.moveByOffset(-50, 50)
				.moveByOffset(50, -50)
				.moveByOffset(-50, 50)
				.release().build();
		sign.perform();
		
		
	}

}
