package practiceAllMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www2.asx.com.au/markets/trade-our-cash-market/directory");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(), 'Accept All Cookies')]")).click();
		
		//1.Count number of rows in a table.
int rows=driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr")).size();
		System.out.println("Total num of rows in the Table: "+rows);
		
//2.Count number of columns in a table.
	int col=driver.findElements(By.xpath("//tbody/tr/td")).size();
	System.out.println("Total no of colums in the table: "+col);
	
	
//first column is under the "th" and reaming columns are under "td"
	
//3. retrieve all the data from the table

for(int r=2;r<=rows;r++) {
	
	for(int c=1;c<=col;c++) {
		String values=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+r+"]/th["+c+"]")).getText();
	System.out.println(values);
		
	}
}
//How I can get all the data from the table?

	}

}
