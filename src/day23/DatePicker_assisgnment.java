package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker_assisgnment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");	
		driver.manage().window().maximize();
		
//driver.findElement(By.id("datepicker")).click();//open the calender
//input
String year="2019";
String month="June";
String date="12";

driver.findElement(By.xpath("//input[@class='hasDatepicker']")).click();

while(true) {
	
	String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();


if(year.equals(yr) && month.equals(mon)) {
	 break;
}

driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //previous button
//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next button

}
	
// buttons are not working 
    }


 }
