package xpathconcept;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("vijaymane");
		driver.findElement(By.name("password")).sendKeys("8055188485");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
		//driver.findElement(By.xpath("//a[text()='Smith Jones']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		ArrayList<String> storeText= getUserDetails("Smith Jones");
		System.out.println(storeText);
		
//		selectContact("Smith Jones");
//		selectContact("Carie Brian");
		
	}
	
	
	public static ArrayList<String>  getUserDetails(String name) {
		List<WebElement> text=driver.findElements(By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td"));
		ArrayList<String> aa= new ArrayList<String>();
		for(int i=0;i<text.size()-1;i++) {
			String contactText=text.get(i).getText();
			System.out.print(contactText +" ");
			aa.add(contactText);
			
			}
		return aa;
	}
	public static void selectContact(String name) {
		String conn_path="//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(conn_path)).click();
		
	}

}
