package day23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class_exampleDataPicker {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");	
		driver.switchTo().frame(0);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("03/15/2021");  //MM/DD/YYYY
		
		
				//Logic for selecting date from Date picker...
				
				//Input
				String year="2020";
				String month="March";
				String date="15";
				
				
				driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // opens the Date Picker
				
				
				//selecting Month & year
				while(true)
				{
					String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();  // Month
					String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();  //YEAR
					
					if(year.equals(yr) && month.equals(mon))
					{
						break;
					}
					//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Next Button
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Prev Button
				}
				
				//selectign date
				
				/*List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

				for(WebElement ele:allDates)
				{
					String dt=ele.getText();
					if(dt.equals(date))
					{
						ele.click();
						break;
					}
				}*/
				

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
