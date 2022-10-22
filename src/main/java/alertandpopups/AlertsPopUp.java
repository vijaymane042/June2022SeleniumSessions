package alertandpopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsPopUp {
	static WebDriver driver;
static Alert action;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		// three types of JS alert pop up
		//1. alert --JS pop up , modal dialogue pop up
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(4000);
		action=driver.switchTo().alert();
		String jsAlertText=action.getText();
		System.out.println(jsAlertText);
		//action.accept();
		action.dismiss();
		
		//2. prompt
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(4000);
		action=driver.switchTo().alert();
		String jsConfirmText=action.getText();
		System.out.println(jsConfirmText);
		//action.accept();
		action.dismiss();
		
		//3. confirm 
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(4000);
		action=driver.switchTo().alert();
		String jsPromptText=action.getText();
		System.out.println(jsPromptText);
		action.sendKeys(jsPromptText);
		Thread.sleep(4000);
		//action.accept();
		//action.dismiss();
		
	}

}
