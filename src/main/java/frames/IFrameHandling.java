package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");
		driver.findElement(By.id("imageTemplateContainer")).click();
		driver.switchTo().frame(driver.findElement(By.id("frame-one102941247")));
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("ABC");
	}

}
