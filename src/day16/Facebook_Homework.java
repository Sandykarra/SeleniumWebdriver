package day16;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.graph.SuccessorsFunction;

public class Facebook_Homework {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.facebook.com/r.php");
		driver.findElement(By.cssSelector("button[data-cookiebanner='accept_button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Sugar");
		driver.findElement(By.name("lastname")).sendKeys("Candy");
//driver.findElement(By.name("reg_email__")).sendKeys("07572367896");
		driver.findElement(By.name("reg_email__")).sendKeys("javaselenium523@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("javaselenium523@gmail.com");
driver.findElement(By.name("reg_passwd__")).sendKeys("Welcome1234");

//dropdown*************************

//method:1(short cut)
Select date=new Select(driver.findElement(By.name("birthday_day")));
date.selectByIndex(4);

//method:2
/*WebElement date=driver.findElement(By.name("birthday_day"));
Select DOB =new Select(date);
List<WebElement> dlist=DOB.getOptions();

System.out.println("All the options in the list: "+dlist.size());
 capture the options
for(WebElement d:dlist) {
	System.out.println("printing all the options of the date: "+d.getText());
}
select the date option
DOB.selectByIndex(8);*/

//*************************************************************************
//month 
//mixed with the select class
Select month=new Select(driver.findElement(By.id("month")));
month.selectByVisibleText("Apr");
//year
Select year=new Select(driver.findElement(By.id("year")));
year.selectByVisibleText("2001");

//Radiobuttons
WebElement Radiobutton=driver.findElement(By.xpath("//input[@id=\"u_0_7_ci\" or @value=\"1\"]"));
System.out.println("The female radio button is selected before : "+Radiobutton.isSelected());
	Radiobutton.click();
	System.out.println("The female radio button is selected after: "+Radiobutton.isSelected());
	
	//signup**************
	  driver.findElement(By.xpath("//button[@name=\"websubmit\"]")).click();
	  Thread.sleep(3000);
	 if(driver.getTitle().equals("https://www.facebook.com/r.php")) {
		 System.out.println("Testcase passed");
		 
	 }else {
		 System.out.println("Test case failed"); 
	 }
	driver.close();
	}

	
	}


