package xpathconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath {
static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		
		//for backward traversing use -  /..
		//invalid way
		//InvalidSelectorException: invalid selector
		//driver.findElement(By.xpath("///////input[####id='username']")).sendKeys("abc");
		
		//driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("abc");
		//InvalidSelectorException: Compound class names not permitted
	
		//valid
		//driver.findElement(By.cssSelector(".form-control.private-form__control.login-email")).sendKeys("abc");
		//Invalid--nosuchelement exception
		//driver.findElement(By.cssSelector("form-control private-form__control login-email")).sendKeys("abc");
		
		//valid
		//driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("abc");
		//driver.findElement(By.className("login-email")).sendKeys("abc");
		
		
		driver.findElement(By.xpath("//input[@class='private-form__control login-email']")).sendKeys("abc");
		//NoSuchElementException: no such element: Unable to locate element
		
		//Interview question: You have to go to the confirm password without using index??????
		//Ans : (//input[@class='form-control'])[last()]
		//You have to go to confirm that the help link is available on the page or not?
		//Ans : this is the right answer (//div[@class='navFooterVerticalColumn navAccessibility']//a)[last()]
        //Absolute path: html/body/header/div/div/div[2]/div/input
		
		/*
		 * Relative Path/Custom Path
		 */
		
		//htmltagname[@attr='value']--//input[@name='search']
		//htmltagname[@attr='value' and @attr1='value1']--//input[@id='input-firstname' and @class='form-control']
		//htmltagname[@attr='value' and @attr1='value1' and @attr2='value2']--//input[@placeholder='First Name' and @class='form-control' and @name='firstname']
		//htmltagname[@attr='value' or @attr1='value1']--//input[@placeholder='First Name' or @class='form-control']
		//htmltagname[text()='value']--//a[text()='Desktops']
		//htmltagname[text()='value' and @attr1='value1']--//a[text()='Desktops' and @class='dropdown-toggle']
		//htmltagname[text()='value' or @attr1='value1']--//a[text()='Laptops & Notebooks' or @class='dropdown-toggle']
		//Dynamic attr <input id='firstname_123'> //input[contains(@id,'firstname_')]
		//htmltagname[contains(text(),'value')]--//h2[contains(text(),'Returning Customer')]
		////h2[text()='Returning Customer')]
		//htmltagname[contains(@attr,'value')]--//input[contains(@value,'Login')]
		//htmltagname[contains(text(),'value')and contains(@attr,'value')]--//a[contains(text(),'Books') and contains(@class,'nav-a  ')]
		//htmltagname[contains(@attr,'value')and text()='value')]
		////a[contains(text(),'Books') and @class='nav-a  ']--//a[contains(@class,'nav-a  ') and text()='Books']
		//htmltagname[contains(text(),'value'and')or @attr='value')]--//a[contains(text(),'Books') or @class='nav-a  ']
		//htmltagname[contains(@attr,'value') and contains(@attr1,'value1')]--//input[contains(@id,'twotabsearchtextbox') and contains(@name,'field-keywords')]
		//htmltagname[starts-with(text(),'value')]--//label[starts-with(text(),'E-Mail')]
		//htmltagname[starts-with(@attr,'value')]--//input[starts-with(@placeholder,'E-Mail')]--//a[starts-with(@href,'/gp/help/')]
		//Ends with in Xpath : NA
		//Index:(//input[@class='form-control'])[1]--(//input[@class='form-control'])[position()=1]
		//(//input[@class='form-control'])[last()]--last element
		//(//input[@class='form-control'])[last()-1]--second last element
		//htmltagname[@attr='value']/parent::tagname
		//htmltagname[@attr='value']/parent::tagname/preceding-sibling::tagname
		//htmltagname[@attr='value']/child::tagname
		//htmltagname[@attr='value']/following-sibling::tagname
		//htmltagname[@attr='value']/ancestor::tagname
		

	}

}
