package frames;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandlind {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		driver.switchTo().frame((WebElement) driver.findElements(By.xpath("//frameset//frame")));
		List<WebElement> totalFrames=driver.findElements(By.xpath("//html//head/title"));
		System.out.println(totalFrames.size());
		for(WebElement e : totalFrames) {
			String text=e.getText();
			System.out.println(text);
		}
		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
//		driver.switchTo().frame(driver.findElement(By.name("main")));
//		String text=driver.findElement(By.xpath("/html/body/h2")).getText();
//		System.out.println(text);
//		driver.switchTo().defaultContent();//return back to the main page

	}

}
