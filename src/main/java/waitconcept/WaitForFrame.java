package waitconcept;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {

	static WebDriver driver;
	static Alert action;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://www.londonfreelance.org/courses/frames/index.html");
			
			By frameLocator =By.xpath("//frame[@name='content']");
			By headerName= By.xpath("//h1[text()='Example home page ']");
			WebElement frameElement = driver.findElement(frameLocator);
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(4));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement)));
			//waitForFrame(5, frameLocator);
			//waitForFrame(2, "content");
			//waitForFrame(1, 4);
			waitForFrame(0, frameElement);
			System.out.println(driver.findElement(headerName).getText());

	}
		
		public static void waitForFrame(int timeouts, By frameLocator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		}
		
		public static void waitForFrame(int timeouts, String frameNameOrId) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
		}
		
		public static void waitForFrame(int timeouts, int frameIndex) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		}
		
		public static void waitForFrame(int timeouts, WebElement frameElement) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		}

}
