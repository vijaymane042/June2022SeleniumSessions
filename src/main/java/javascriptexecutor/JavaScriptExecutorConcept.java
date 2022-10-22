package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://classic.crmpro.com/index.html");
		driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
		WebElement d=driver.findElement(By.xpath("//h2[text()='Flipkart Plus']"));
		scrollIntoView(d);
		drowBorader(d);
//		WebElement clickonEle = driver.findElement(By.xpath("//a[text()='Sign Up']"));
//		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
//		JavaScriptExecutorConcept jj=new JavaScriptExecutorConcept();
//		jj.flash(login);
		// generateAlert("hello java");
//		refreshBrowserByJS();
//		goBackwordByJS();
//		goForwordByJS();
//		String pageText=getPageInnerText();
//		System.out.println(pageText);
//		
//		String title=getPageTitle();
////		System.out.println(title);
//		clickOnElement(clickonEle);
//		scrollPageDown();
//		Thread.sleep(2000);
//		scrollPageUp();
//		Thread.sleep(2000);
//		scrollPageDown("10000");
		
	}

	public static void generateAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	public static void refreshBrowserByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public static void goBackwordByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(-1)");
	}

	public static void goForwordByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(1)");
	}

	public static String getPageInnerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// return (String) js.executeScript("return
		// document.documentElement.innerText");
		return js.executeScript("return document.documentElement.innerText").toString();
	}

	public static String getPageTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}

	// Java script click
	// Action class click
	// Click
	public static void clickOnElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public  void flash(WebElement element) {
		String bgColor=element.getCssValue("backgroundColor");
		for(int i=0; i<3;i++) {
			changeColor("rgb(0,1000,0)", element);
			changeColor(bgColor,element);	
		}
		}

	public void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
	}
	
	public static void scrollPageDown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollPageDown(String height) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,'"+height+"')");
	}
	public static void scrollPageUp() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void drowBorader(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
