package day23;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_Datapicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");
driver.manage().window().maximize();

	 //declaration
String year="2020";
String month ="June";
String date="22";

driver.findElement(By.cssSelector("input[id=\"datepicker\"]")).click(); //open the calendar
while(true) {
	String mon=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText(); //month
	
	
	String yr=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText(); //year
	System.out.println(mon+"  "+yr);
	if(month.equals(mon) && year.equals(yr))
	{
		break;	
	}
	
	//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next button
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//previous button
}
	// break command is not working .........................
	
	}

}
