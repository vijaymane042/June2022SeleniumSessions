package xpathconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCSSSelector {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
       // driver.findElement(By.cssSelector("#UIFormControl-2")).sendKeys("abc");
		
		//#id--#UIFormControl-2
		//.class--.uiTextInputUnstyled
		//htmltagnm.class--input.uiTextInputUnstyled
		//htmltagnm#id---input#UIFormControl-2
		
		//htmltagnm.class#id--input.uiTextInputUnstyled#UIFormControl-2
		//htmltagnm#id.class--input#UIFormControl-2.uiTextInputUnstyled
		
		//.class1.class2.class3......classn
		//.form-control.private-form__control.SignupUITextInput.undefined.private-form__control--unstyled.uiTextInputUnstyled
        //htmltagname.class1.class2.class3......classn
        //input.form-control.private-form__control.login-email
        //htmltagnm.class1.class2.class3......#id
        //input.form-control.private-form__control.login-email#username
        //input#username.form-control.private-form__control.login-email
        //#username.form-control.private-form__control.login-email
        //.form-control.private-form__control.login-email#username
        
        //other attributes
        //htmltag[attr='value']
        //input[type='email']
        //input[value='login']--css
        //input[@attr='login']--xpath
        
        //htmltag[attr='value1'][attr='value2']
        //input[type='email'][tabindex='1']
        //input[type='email'][tabindex='1'][id='username']
        //input[type='email'][tabindex='1']#username
        //input#username[type='email'][tabindex='1']
        //input[type='email'][tabindex='1'].login-email
        //input.login-email[type='email'][tabindex='1']
        
        //htmltag[attr*='value']--* keyword used for contains method for css selector
        //input[class*='email']
        //input[id*='email']
        
        //^ used for starts with for css
        //htmltag[attr^='value']
        //input[placeholder^='First']
        
        //$ user for ends with for css
        //htmltag[attr$='value']
        //input[placeholder$='Name']
        
        //parent to child
        //fieldset[id='account'] div--11  (with space getting direct child and indirect child)
        //fieldset[id='account'] > div--5 (with > getting only direct child )
        
        //Backward traversing--NA
        //child to parent or grandparent--NA: major disadvantages of css
        //webtable handling(preceding-sibling)--NA:works with forward direction
        
        //following sibling-yes :using + you can go to following sibling
        //div[class='form-group required']+div
        
        //                                   Xpath                  vs              Css
        //1.Syntax                           Complex                                Simple
        //2.Backword(child to parent)        Yes                                    No
        //3.text()                           Yes                                    No
        //4.Siblings                         Yes                                    Limited-Only forward sibling allows
        //5.Webtable                         Yes                                    Limited
        //6.Parent to child                  Yes                                    Yes
        //7.Performance                      Good                                   Good
        
		//index--(//fieldset[id='account'] )[2]
		//SVG
		//RelativeLocator
		//Shadow DOM
		//Comma
		//not
        List<WebElement> count=driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,small#password-description"));
        System.out.println(count.size());
        
        //not in css
        //.form-control.private-form__control.login-email
        //input.form-control.private-form__control:not(.login-email)
        //input.form-control.private-form__control:not(#username)
	}

}
