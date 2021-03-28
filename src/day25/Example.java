package day25;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Example {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
	driver.manage().window().minimize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String path="C:\\Demofiles\\caldata2.xlsx";
	int rows=XLUtils.getRowCount(path, "Sheet1");
	
	for(int i=1;i<=rows;i++) //i represents row
	{	
		//Get the row data from sheet
		String inidepo=XLUtils.getCellData(path, "Sheet1", i, 0);
		String interest_rate=XLUtils.getCellData(path, "Sheet1", i, 1);
		String month_length=XLUtils.getCellData(path, "Sheet1", i, 2);
		String compounding=XLUtils.getCellData(path, "Sheet1", i, 3);
		
		String exptotal=XLUtils.getCellData(path, "Sheet1", i, 4);
		
		//App code
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(inidepo);
		
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(month_length);
		
		driver.findElement(By.xpath("//input[@id='mat-input-2']")).clear();
		driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(interest_rate);
		
		driver.findElement(By.xpath("//button[normalize-space()=\"Let's run the numbers\"]")).click(); 
		
		//Select comp=new Select(driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[2]/div")));
		//comp.selectByVisibleText(compounding);
		Thread.sleep(3000);
		
		String acttotal=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
	
	
	
		//validation
		if(exptotal.equals(acttotal))
		{
			System.out.println("Test passed");
			XLUtils.setCellData(path,"Sheet1", i, 6, "Passed");
			XLUtils.fillGreenColor(path,"Sheet1", i, 6);
			
		}
		else
		{
			System.out.println("Test failed");
			XLUtils.setCellData(path,"Sheet1", i, 6, "Failed");
			XLUtils.fillRedColor(path,"Sheet1", i, 6);
		}
}	

	
	
	
	
	
	
	}

}
