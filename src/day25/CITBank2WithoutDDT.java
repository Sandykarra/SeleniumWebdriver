package day25;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CITBank2WithoutDDT {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
	driver.manage().window().minimize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Initialization.......
	
	String path="C:\\Demofiles\\test\\CItBank.xlsx";
	int rows=XLUtils.getRowCount(path, "Sheet1"); //row count
		
		for(int i=1;i<=rows;i++) {
			//get celldata from sheet
			
			String Deposit_amount = XLUtils.getCellData(path, "Sheet1", i, 0);
			String Interest_rate = XLUtils.getCellData(path, "Sheet1", i, 1);
			String Length = XLUtils.getCellData(path, "Sheet1", i, 2);
			String dropdownvalue = XLUtils.getCellData(path, "Sheet1", i, 3);
			
			String Expected_total = XLUtils.getCellData(path, "Sheet1", i, 4);
			
			
			//App code
			
			driver.findElement(By.xpath("//input[@id = 'mat-input-0']")).clear();
			driver.findElement(By.xpath("//input[@id = 'mat-input-0']")).sendKeys(Deposit_amount);
			driver.findElement(By.xpath("//input[@id='mat-input-2']")).clear();
			driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(Interest_rate);
			driver.findElement(By.xpath("//input[@id='mat-input-1']")).clear();
			driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(Length);
			
			WebElement clictDrpdown=driver.findElement(By.xpath("//div[@class='mat-select-arrow ng-tns-c115-4']"));
			clictDrpdown.click();
			Thread.sleep(3000);
			//String xpath = "//span[contains(text(),' Compounded Monthly ')]";
			String xpath = "//span[contains(text(),' "+dropdownvalue+" ')]";
			driver.findElement(By.xpath(xpath)).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("CIT-chart-submit")).click();
			Thread.sleep(3000);
			String act_val = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
				
			if (Expected_total.equals(act_val)) {
				System.out.println("Test Passed");
				//XLUtils.setCellData(path, "Sheet1", i, 5,act_val);
				XLUtils.setCellData(path, "Sheet1", i, 6,"Passed");
				XLUtils.fillGreenColor(path,"Sheet1", i, 6);
			}else {
				System.out.println("Test Failed");
				XLUtils.setCellData(path, "Sheet1", i, 6,"Failed");
				XLUtils.fillRedColor(path,"Sheet1", i, 6);
			}
		}
		
		driver.close();

	
	
	
	
	
	
	
	
	}

}
