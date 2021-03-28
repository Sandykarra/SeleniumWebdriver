package allQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Part11_dropdown {
	WebDriver driver;
	
	// this technique help to find dropdown elem are sorted order or not
@BeforeClass
	public void setup() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
}
@Test
public void Dropdown() {
	driver.get("https://www.twoplugs.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[text()= 'Live Posting']")).click(); //livepostin
	WebElement dropdown=driver.findElement(By.xpath("//select[@name=\"category_id\"]"));
Select dropselected=new Select(dropdown); 
List<WebElement>options=dropselected.getOptions();
//select tag has to be there to choose the xpath:

ArrayList orginallist=new ArrayList();
ArrayList templlist=new ArrayList(); // to hold multuple values

for(WebElement opt:options) {
	
	orginallist.add(opt.getText());
	 templlist.add(opt.getText());
}


System.out.println("orginallist: "+orginallist);
System.out.println("templlist: "+  templlist);

Collections.sort( templlist); //sorting

System.out.println("After orginallist: "+orginallist);
System.out.println("After templist sorting : "+  templlist);

if(orginallist.equals(templlist)) {

	System.out.println("Dropdown sorted");
}else {
	System.out.println("Dropdown unsorted");
}

driver.close();

}











}