package xpathconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGelement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://petdiseasealerts.org/forecast-map/#/");
		
		driver.get("https://www.flipkart.com/");
		//SVG Element
		
	    //*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='state']
		
//		String svg_Xpath="//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='state']";
//		List<WebElement> allStateList=driver.findElements(By.xpath(svg_Xpath));
//		for(WebElement e: allStateList) {
//			String stateName=e.getAttribute("id");
//			System.out.println(stateName);
//		}

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Mobile");
		WebElement ele=driver.findElement(By.xpath("//button[@type='submit']//*[local-name()='svg']"));
		ele.click();
	}

}
