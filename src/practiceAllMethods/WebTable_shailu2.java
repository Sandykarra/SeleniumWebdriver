package practiceAllMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_shailu2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www2.asx.com.au/markets/trade-our-cash-market/directory");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(), 'Accept All Cookies')]")).click();
		
		//1.Count number of rows in a table.
int rows=driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr")).size();
		System.out.println("Total num of rows in the Table: "+rows);
		
//2.Count number of colums in a table.
	int col=driver.findElements(By.xpath("//tbody/tr/td")).size();
	System.out.println("Total no of colums in the table: "+col);
	
	//3.by using enhanced loop to get data
	
	List<WebElement> alldata=driver.findElements(By.xpath("//table[@class='table']/tbody/tr/th"));
	for(WebElement data:alldata) {
		
		System.out.print("all the data from table: "+data.getText()+"   ");
	}
	//System.out.println();
	
	//3. reterive all the data from table
	
	/*for(int r=2; r<rows;r++) {
		String TableDAta=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]")).getText();
		System.out.print(TableDAta);	
		}*/
	
	
	
	driver.close();
	
	}
	}


