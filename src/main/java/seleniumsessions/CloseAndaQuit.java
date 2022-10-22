package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseAndaQuit {

	public static void main(String[] args) {
	            WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "D:\\Vijay\\Selenium setup\\chromedriver\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
		        driver.get("https://www.google.co.in/");
		        String url=driver.getCurrentUrl();
		        System.out.println("Current URL :"+url);
		        String title=driver.getTitle();
		        System.out.println("Page title is :"+title);
		        if(title.contains("Google"))
		        {
		        	System.out.println("PASSED");
		        }
		        else {
		        	System.out.println("FAILED");
		        }
		       
		        driver.quit();//NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		        //driver.close();//NoSuchSessionException: invalid session id
		        
		        System.out.println(driver.getTitle());
			}

	}


