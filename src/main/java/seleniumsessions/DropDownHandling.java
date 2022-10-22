package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		// dropdown: select tag is mandatory
//		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
//		Select sel = new Select(country);
//		List<WebElement> getAllOptionCount = sel.getOptions();
//		System.out.println(getAllOptionCount.size()-1);
//		for (WebElement e : getAllOptionCount) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		// country.sendKeys("India");
		// sel.selectByIndex(3);
		// sel.selectByValue("India");
		// sel.selectByVisibleText("Brazil");

		By selectDropDown = By.id("Form_getForm_Country");

		// System.out.println("Count of country is :"
		// +getDropDownOptionsCount(selectDropDown));
		// System.out.println("Count of country is :"
		// +doGetDropDownCount(selectDropDown));
		List<String> printText = doGetDropDownListText(selectDropDown);
		System.out.println(printText);
		// getAllOptionsCount(selectDropDown);
//		doSelectDropDownByIndex(selectDropDown, 7);
//		doSelectDropDownByValue(selectDropDown, "Belarus");
//		doSelectDropDownByVisibleText(selectDropDown, "Antigua and Barbuda");
	}

	static public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	static public void doSelectDropDownByIndex(By locator, int index) {
		Select sel = new Select(getElement(locator));
		sel.selectByIndex(index);
	}

	static public void doSelectDropDownByValue(By locator, String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByValue(value);
	}

	static public void doSelectDropDownByVisibleText(By locator, String VisibleText) {
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(VisibleText);
	}

	static public List<WebElement> getDropDownOptionsCount(By locator) {
		Select sel = new Select(getElement(locator));
		return sel.getOptions();
	}

	static public int doGetDropDownCount(By locator) {
		return getDropDownOptionsCount(locator).size();
	}

	static public List<String> doGetDropDownListText(By locator) {
		List<WebElement> optionCount = getDropDownOptionsCount(locator);
		List<String> addText = new ArrayList<String>();
		for (WebElement e : optionCount) {
			String str = e.getText();
			addText.add(str);
		}
		return addText;
	}
}
