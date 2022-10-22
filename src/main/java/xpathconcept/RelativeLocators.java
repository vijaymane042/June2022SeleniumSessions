package xpathconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * RelativeLocator needs to import manually because it is static method
 */
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;

public class RelativeLocators {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");

		WebElement ele = driver.findElement(By.linkText("Fort-Saskatchewan, Canada"));
		String city = ele.getText();
		System.out.println(city);

		WebElement ele1 = driver.findElement(By.linkText("Nova Scotia"));

		// left of element
		String leftIndex = driver.findElement(with(By.tagName("P")).toLeftOf(ele)).getText();
		System.out.println("Left :" + leftIndex);

		// right of element
		String rightIndex = driver.findElement(with(By.tagName("P")).toRightOf(ele)).getText();
		System.out.println("Right :" + rightIndex);

		// above of element
		String aboveIndex = driver.findElement(with(By.tagName("P")).above(ele)).getText();
		System.out.println("above :" + aboveIndex);

		// below of element
		String belowIndex = driver.findElement(with(By.tagName("P")).below(ele)).getText();
		System.out.println("below :" + belowIndex);

		// below of element
		String near = driver.findElement(with(By.tagName("a")).near(ele1)).getText();
		System.out.println("near :" + near);
		String near1 = driver.findElement(with(By.tagName("p")).near(ele)).getAttribute("class");
		System.out.println("near :" + near1);
	}

}
