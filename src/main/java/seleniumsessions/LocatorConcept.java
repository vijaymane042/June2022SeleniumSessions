package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
//		driver.findElement(By.id("input-firstname")).sendKeys("abc");//first preference is for ID I
//		driver.findElement(By.name("lastname")).sendKeys("bcd");//Name can be duplicate II
//		driver.findElement(By.className("form-control")).sendKeys("test");//className can be duplicate III
//		driver.findElement(By.linkText("Login")).click();//only for the links
//		driver.findElement(By.partialLinkText("Recurring")).click();//only  for links
//		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input[1]")).click();
//		driver.findElement(By.cssSelector("#column-right > div > a:nth-child(2)")).click();
		String text= driver.findElement(By.tagName("legend")).getText();
		System.out.println(text);
		
		By header=By.tagName("legend");
		String actualHeaderName = doGetText(header);
		if(actualHeaderName.equals("Your Personal Details"))
		{
			System.out.println("correct name");
		}
		else
		{
			System.out.println("Incorrect name");
		}
	}
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}
