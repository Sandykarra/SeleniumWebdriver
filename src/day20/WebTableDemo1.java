package day20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Operations
------------------------
1) How many rows in  table
2) How many columns in a table
3) Retrieve the specific row/column data
4) Retrieve all the data from the table
5) Print book names whose author is Mukesh(Conditional based retrieval of rows)
6) Find sum of cost of all books listed */
public class WebTableDemo1 {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		//1) How many rows in  table
	int	rows=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
	System.out.println(rows);
		//2) How many columns in a table
int	colums=driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
System.out.println(colums);
		//3) Retrieve the specific row/column data 
 

String value=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[5]/td[4]")).getText();
System.out.println(value);
// 4) Retrieve all the data from the table
for(int r=2;r<rows;r++) {
	
	for(int c=1;c<colums;c++) {
	 value=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/td["+c+"]")).getText();
		System.out.print(value+"  ");	
	}
	System.out.println();
}

 driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
