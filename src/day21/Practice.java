package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
ChromeDriver dobj=new ChromeDriver();
dobj.get("https://testautomationpractice.blogspot.com/");
System.out.println("The title of the page: "+dobj.getTitle());
String url=dobj.getCurrentUrl();
if(url.equals("https://testautomationpractice.blogspot.com/")) {

	System.out.println("Test case passed!!");
}else {
	System.out.println("Test case Failed!");
}
	
	dobj.switchTo().frame("frame-one1434677811");
	dobj.findElement(By.id("RESULT_TextField-1")).sendKeys("Michele");
	dobj.findElement(By.name("RESULT_TextField-2")).sendKeys("Maven");
	dobj.findElement(By.id("RESULT_TextField-3")).sendKeys("078345879");
	dobj.findElement(By.name("RESULT_TextField-4")).sendKeys("India");
	dobj.findElement(By.id("RESULT_TextField-5")).sendKeys("Hyderbad");
	dobj.findElement(By.id("RESULT_TextField-6")).sendKeys("bethisandhya.reddy@gmail.com");
	
	
	
	
	
	}
	
	
	
	}


