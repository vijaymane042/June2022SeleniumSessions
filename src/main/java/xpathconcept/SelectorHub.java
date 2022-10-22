package xpathconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectorHub {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		String before_xpath = "table[@id='resultTable']//tbody/tr[";
		String after_xpath="]/child::td";
		// gettext("Joe.Root");
		for(int i=0;i<6;i++) {
		List<WebElement> rowCount= driver.findElements(By.xpath("+before_xpath+"+ i+"+after_xpath+"));
		System.out.println(rowCount.size());
		
			String t=rowCount.get(i).getText();
			System.out.println(t);
		
		}
	}

	public static void gettext(String name) {
		List<WebElement> name1 = driver.findElements(
				By.xpath("//a[text()='" + name + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"));

		// List<WebElement>
		// checkbox=driver.findElements(By.xpath("//table[@id='resultTable']/child::thead/following-sibling::tbody/child::tr/td[1]"));

		for (WebElement e : name1) {

			String text = e.getText();
			System.out.println(text);
			e.click();

		}
	}
}
