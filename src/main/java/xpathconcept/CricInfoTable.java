package xpathconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoTable {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/new-zealand-in-australia-2022-1317459/australia-vs-new-zealand-3rd-odi-1317481/full-scorecard");

		//WebElement a=driver.findElement(By.xpath("//span[text()='Steven Smith']/ancestor::td/following-sibling::td"));
//		String text=a.getText();
//		System.out.println(text);
		getWKTtakernm("Aaron Finch");
		getWKTtakerName("Josh Inglis");
		
	}
	public static void getWKTtakerName(String name) {
		List<WebElement> list=driver.findElements(By.xpath("//span[text()='"+name+"']/ancestor::td/following-sibling::td"));
		
		for(WebElement e:list) {
			String text=e.getText();
			System.out.println(text);
		}
		 
	}
	public static String getWKTtakernm(String name) {
		WebElement list=driver.findElement(By.xpath("//span[text()='"+name+"']/ancestor::td/following-sibling::td"));
		String bollerNM=list.getText();
		System.out.println(bollerNM);
		return bollerNM;
	}
	
	
}
