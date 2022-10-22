package waitconcept;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		alert.accept();
//		Alert alert=WaitForAlert(5);
//		System.out.println(alert.getText());
//		alert.accept();
		String alertText=getAlertText(5);
		System.out.println(alertText);
		acceptAlert(5);
		
	}
 public static Alert waitForAlert(int timeouts) {
	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		return wait.until(ExpectedConditions.alertIsPresent());
 }
 
 public static String getAlertText(int timeouts) {
	 return waitForAlert(timeouts).getText();
 }
 
 public static void acceptAlert(int timeouts) {
	  waitForAlert(timeouts).accept();
 }
 
 public static void dismissAlert(int timeouts) {
	  waitForAlert(timeouts).dismiss();
}
 
 public static void alertWithSendkeys(int timeouts, String value) {
	  waitForAlert(timeouts).sendKeys(value);
}
}
