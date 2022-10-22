package xpathconcept;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PseudoElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		String firstName="window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')";
		String lasttName="window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')";
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String fieldText = js.executeScript(
//				"return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')")
//				.toString();
//		// window.getComputedStyle(document.querySelector("label[for='input-firstname']"),
//		// '::before').getPropertyValue('content')
//		System.out.println(fieldText);
//		if (fieldText.contains("*")) {
//			System.out.println("Element is a mandatory ");
//		} else {
//			System.out.println("Element is not a mandatory ");
//		}
		System.out.println(checkElementIsMondatory(firstName));;
		checkElementIsMondatory(lasttName);
	}

	public static boolean checkElementIsMondatory(String jsScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String manText = js.executeScript("return "+jsScript).toString();
		// window.getComputedStyle(document.querySelector("label[for='input-firstname']"),
		// '::before').getPropertyValue('content')
		System.out.println(manText);
		if (manText.contains("*")) {
			System.out.println("Element is a mandatory ");
			return true;
		} else {
			System.out.println("Element is not a mandatory ");
			return false;
		}

	}

}
