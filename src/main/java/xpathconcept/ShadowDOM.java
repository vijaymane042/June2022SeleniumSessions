package xpathconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		driver.switchTo().frame("pact");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement tea=(WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
//		tea.sendKeys("masala tea");
		String shadow_Xpath="document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")";
		String shadow_Xpath1="document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		sendTextOverShadowDomElement(shadow_Xpath,"masala tea");
		sendTextOverShadowDomElement(shadow_Xpath1, "lemon tea");

	}
	
	public static void sendTextOverShadowDomElement( String shadowDOMElement,String text) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele=(WebElement)js.executeScript("return "+shadowDOMElement);
		ele.sendKeys(text);
	}

}
