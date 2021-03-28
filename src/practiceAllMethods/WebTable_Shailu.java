package practiceAllMethods;
/*1.       Count number of rows in a table.
2.       Count number of columns in a table.
3.       Print text from row8 and column 1.
4.       Capture Commercial & Professional Services text from  where company name 333D LIMITED
5.       360 CAPITAL REIT is present in table or not
6.       Get data from row 10*/

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTable_Shailu {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www2.asx.com.au/markets/trade-our-cash-market/directory");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(), 'Accept All Cookies')]")).click();
		
		//1.Count number of rows in a table.
List<WebElement> rows=driver.findElements(By.xpath("//table[@class=\"table\"]/tbody/tr"));
		System.out.println("Total num of rows in the Table: "+rows.size());
		
		//2.Count number of columns in a table.
List<WebElement> col=driver.findElements(By.xpath("//table[@class=\"table\"]/thead/tr/th"));	
System.out.println("Num of colums: "+col.size());
Thread.sleep(3000);

	//3.Print text from row8 and column 1.
String value=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[8]/th[1]")).getText();

System.out.println("The row 8 and colu 1 text: "+value);
	//4 Capture Commercial & Professional Services text from  where company name 333D
for(int r=1;r<rows.size();r++) {
	
	for(int c=1;c<col.size();c++) {
		String companyName =driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td[1]")).getText();
	System.out.println("All names of company: "+companyName);
		if("333D LIMITED".equals(companyName)){
			Thread.sleep(5000);
		String Industry=driver.findElement(By.xpath("//*[@id='results-container_5']/table/tbody/tr["+r+"]/td[2]")).getText();
		System.out.println("333D companyService type: "+Industry);
		break;
	}
	
	}
}
	
// 5.360 CAPITAL REIT is present in table or not

boolean f=false;
for(int r=1;r<rows.size();r++) {
	Thread.sleep(3000);
	String companyName =driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td[1]")).getText();
	//System.out.println("all company name: "+companyName);
	String givenName="360 CAPITAL REIT";
	if(givenName.equalsIgnoreCase (companyName)) {
		f=true;
		break;
	}
}
Assert.assertTrue(f,"name is not exist");	
	
//6.Get data from row 10
String Get_RowData=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[10]")).getText();
System.out.print("10th row data: "+Get_RowData);

	

//7 to retrieve all the data frome table
List<WebElement> colums=driver.findElements(By.xpath("//tbody/tr/th"));
Thread.sleep(5000);
for(int r=1;r<rows.size();r++) {
	
	for(int c=1;c<colums.size();c++) {
		
		String All_Data=driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+r+"]/td["+c+"]")).getText();
		System.out.println(All_Data);
		
	}
}

driver.close();
	}

}
