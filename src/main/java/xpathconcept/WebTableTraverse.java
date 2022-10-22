package xpathconcept;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
 
		int row=getRowCount();
		System.out.println("Row count :" +row);
		int col=getColumnCount();
		System.out.println("Row count :" +col);
		
		////table[@id="customers"]//tr[3]//td[1]
		
//		String before_xpath="//table[@id='customers']//tr[";
//		String after_xpath="]//td[1]";
//		for(int i=2;i<=getRowCount()+1;i++) {
//		String completeXpath=before_xpath + i + after_xpath;
//		//System.out.println(completeXpath);
//	    String rowText=	driver.findElement(By.xpath(completeXpath)).getText();
//	    System.out.println(rowText);
//		}
//		
//		System.out.println("------------");
//		String contactBefore_xpath="//table[@id='customers']//tr[";
//		String contactAfter_xpath="]//td[2]";
//		for(int i=2;i<=getRowCount()+1;i++) {
//		String completeXpath=contactBefore_xpath + i + contactAfter_xpath;
//		//System.out.println(completeXpath);
//	    String rowText=	driver.findElement(By.xpath(completeXpath)).getText();
//	    System.out.println(rowText);
//		}
//		
//		System.out.println("------------");
//		String countryBefore_xpath="//table[@id='customers']//tr[";
//		String countryAfter_xpath="]//td[2]";
//		for(int i=2;i<=getRowCount()+1;i++) {
//		String completeXpath=countryBefore_xpath + i + countryAfter_xpath;
//		//System.out.println(completeXpath);
//	    String rowText=	driver.findElement(By.xpath(completeXpath)).getText();
//	    System.out.println(rowText);
//		}
		
//		getCoulmnData(1);	
//		getCoulmnData(2);
//		ArrayList<String> checktext=getCoulmnData(3);
//		if(checktext.contains("Italy"))
//		{
//			System.out.println("Pass");
//		}
		getRowCount(3,2);
	}

	public static void getRowCount(int rowNum,int colNum) {
//		String xpath="//table[@id='customers']//tr["+rowNum+"]//td["+colNum+"]";
//		List<WebElement>RowCount=driver.findElements(By.xpath(xpath));
//		for(WebElement e:RowCount)
//		{
//			String rowtext=e.getText();
//			System.out.println(rowtext);
//		}
		
		for(int j=1;j<=colNum;j++)
		{
			String xpath="//table[@id='customers']//tr["+rowNum+"]//td["+j+"]";
			String rowData=driver.findElement(By.xpath(xpath)).getText();
			System.out.println(rowData);
		}
		
	}
	public static ArrayList<String> getCoulmnData(int colNo) {
		System.out.println("------------");
		String before_xpath="//table[@id='customers']//tr[";
		String after_xpath="]//td["+colNo+"]";
		ArrayList<String> colValueList=new ArrayList<String>();
		for(int i=2;i<=getRowCount()+1;i++) {
		String completeXpath=before_xpath + i + after_xpath;
		//System.out.println(completeXpath);
	    String rowText=	driver.findElement(By.xpath(completeXpath)).getText();
	    System.out.println(rowText);
	    colValueList.add(rowText);
		}
		return colValueList;
	}
	public static int getRowCount() {
		int rowCount= driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		return rowCount-1;
	}
	
	public static int getColumnCount() {
		return driver.findElements(By.xpath("//table[@id='customers']//th")).size();
	}
}
