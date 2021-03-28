package day20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Orange_find {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
         driver.get("http://www.trycatchclasses.com/code/demo/angular4_crud/");
		
		driver.manage().window().maximize();
		
		/****************ADD & VERIFY STUDENT DATA *******************/
		  driver.findElement(By.xpath("//form/input[@name='name']")).sendKeys("Markel Sparkel");
		  driver.findElement(By.xpath("//form/input[@name='contact']")).sendKeys("6475678900");
		  
		  WebElement subjectDropDown = driver.findElement(By.xpath("//form/select[@name='subject']"));
		  Select subjects = new Select(subjectDropDown);
		  subjects.selectByIndex(2); //JS
           driver.findElement(By.xpath("//form/input[@name='marks']")).sendKeys("80");
		  
		  driver.findElement(By.xpath("//form/input[@type='button' and @value='Submit']")).click();
		  
		  //VERIFY THAT THE RECORD CONTAINS THE SAME VALUES ENTERED
		  
		 String recName = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[2]")).getText();
		 String recContact = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[3]")).getText();
		 String recSubject = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[4]")).getText();
		 String recMarks = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[5]")).getText();
		 
		 if(recName.equals("Markel Sparkel") && recContact.equals("6475678900") && recSubject.equals("JS") && recMarks.equals("80"))
		 {
			 System.out.println("ADD - Values verified. Test passed.");
		 }
		 else
		 {
			 System.out.println("ADD - Values not matching. Test failed.");
		 }
		  
		/****************EDIT & VERIFY STUDENT DATA******************/
		 
		 Thread.sleep(1000); //pause on purpose
		 
		driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[6]/button")).click();
		
		Thread.sleep(1000); //pause on purpose
		
		driver.findElement(By.xpath("//form/input[@name='contact']")).clear();
		driver.findElement(By.xpath("//form/input[@name='contact']")).sendKeys("4167899000");
		driver.findElement(By.xpath("//form/input[@type='button' and @value='Submit']")).click();
		
		 String recContactEdited = driver.findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[3]")).getText();
		 
	
	
	
	}

}
