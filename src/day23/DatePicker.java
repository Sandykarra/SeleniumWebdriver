package day23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DatePicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");	
		driver.switchTo().frame(0);
		driver.manage().window().maximize();
		
	//to pick the date and year
		     
		String year="2020";
		String month="june";
		String date="17"; 
		
		//logic for date picker
		
	
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		///input box to open the calender
		
		//selecting Month & year
		while(true ) 
		//when we don't know starting and ending num we use while loop...
		{
		 String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	      String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	
	if(year.equals(yr) && month.equals(mon))
	{
	    break;
	}
	// for the next button
		//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		//go to previous button
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		
		}

		//selectign date
		
				/*List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

				for(WebElement ele:allDates)
				{
					String dt=ele.getText();
					if(dt.equals(test_date))
					{
						ele.click();
						break;
					}
		
	}*/
	}
}
