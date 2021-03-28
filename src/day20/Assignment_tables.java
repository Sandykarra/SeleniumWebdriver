package day20;
/*Assignment
-------------
1) http://www.trycatchclasses.com/code/demo/angular4_crud/
	1) Submit record into a table( Add)
	2) verify data in table after submitting
	3 )verify data in table after Editing  (Edit)
	4) verify delete (Delete)*/

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_tables {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // wait
		driver.get("http://www.trycatchclasses.com/code/demo/angular4_crud/");
		driver.manage().window().maximize();
		
	//1) Submit record into a table( Add)**********************
     driver.findElement(By.name("name")).sendKeys("Hasini"); // Name
	driver.findElement(By.name("contact")).sendKeys("079845328"); // contact num
	
	//dropdowns to select option
	
    Select subject= new Select(driver.findElement(By.xpath("//select[@name=\"subject\"]")));
	subject.selectByVisibleText("JS");
	
	driver.findElement(By.name("marks")).sendKeys("100");
	driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click(); //submit button
	
//2) verify data in table after submitting****************************
 //table path
	WebElement table=driver.findElement(By.xpath("//table[@class='table table-bordered']"));
String name =table.findElement(By.xpath("//td[2]")).getText();
String contact=table.findElement(By.xpath("//td[3]")).getText();
String subj=table.findElement(By.xpath("//td[4]")).getText();
String Marks=table.findElement(By.xpath("//td[5]")).getText();

// verifying data with table
if(name.equals("Hasini") && contact.equals("079845328") && subj.equals("JS") && Marks.equals("100")) 
{ 
	System.out.println("Sumbit data has been matched:--passed");
	
}else {
	System.out.println("data hasn't been matched");
}

//3 )verify data in table after Editing***********************
table.findElement(By.xpath("//button[@class=\"btn btn-warning\"]")).click();
driver.findElement(By.name("marks")).clear();
driver.findElement(By.name("marks")).sendKeys("80");
driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click();
Marks=table.findElement(By.xpath("//td[5]")).getText();
if(Marks.equals("80")) {
	System.out.println("Edit student data - Passed\"");
}else {
	System.out.println("Edit student data - Failed");
	
}
//	4) verify delete (Delete)*********************

table.findElement(By.xpath("//button[@class=\"btn btn-danger\"]")).click(); //delete button
String msg=table.findElement(By.xpath("/html/body/app-root/div/div/div[2]/table/h6")).getText();
if(msg.equals("No Data Found")) {

	System.out.println("Delete student data - Passed");
}
else
{
	System.out.println("Delete student data - Failed");
	
	
}
	
	}
}
