package alertandpopups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpHandles {
	static WebDriver driver;
	static Alert action;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String userName="admin";
		String password="admin";
		driver.get("https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/digest_auth");
		//driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='Digest Authentication']")).click();
		String text=driver.findElement(By.xpath("//div[@id='content']//p")).getText();
		System.out.println(text);
		
	}

}
