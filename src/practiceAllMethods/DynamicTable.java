package practiceAllMethods;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www2.asx.com.au/markets/trade-our-cash-market/directory");
	driver.findElement(By.xpath("//button[contains(text(), 'Accept All Cookies')]")).click(); //cookies
List<WebElement> col_headrer=driver.findElements(By.xpath("//table[@class=\"table\"]/thead/tr/th"));
	System.out.println( "The number of colums in the table: "+col_headrer.size()); //size
	List<WebElement> colums=driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr/th"));
	
	//finding the index of the header elements
	Thread.sleep(3000);
	int columnindex=0;
	
	for(int i=0;i<col_headrer.size();i++) {
		System.out.println("Name of the colums: "+col_headrer.get(i).getText());
		if("INDUSTRY".equals(col_headrer.get(i).getText())) {
			columnindex=i;
			break;
			
		}
	}
	System.out.println("selected element index: "+columnindex);
	
	//find specific elements...
	String ener=driver.findElement(By.xpath("//tbody/tr[9]/td[2]")).getText();
	System.out.println(ener);
	
	//find the data from the table dynamically without giving specific row and col
	//1. find the no of rows
	List<WebElement> rows=driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr"));
	System.out.println("total no of rows in the table: "+rows.size());

	//String act_value="99 TECHNOLOGY LIMITED";
	Thread.sleep(3000);
	boolean f= false;
	for(int r=1;r<=rows.size();r++) {
		 String values=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td["+columnindex+"]")).getText();
		System.out.println(values);// it gives above selected index data colum
		 if("Diversified Financials".equalsIgnoreCase(values)) {
			 f=true;
			 break;
			 
		 }
	}
Assert.assertTrue(f,"both names are not matching");
	}
}
