package day25;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDeposit {
	
		public static void main(String[] args) throws IOException, InterruptedException {
	     System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
			
		String path="C:\\Demofiles\\fixeddeposit.xlsx";
		int rows=XLUtils.getRowCount(path, "Sheet1");
			
			for(int i=1;i<=rows;i++) //i represents row
			{	
				//Get the row data from sheet
				String pric=XLUtils.getCellData(path, "Sheet1", i, 0);
				String rateofinterest=XLUtils.getCellData(path, "Sheet1", i, 1);
				String per1=XLUtils.getCellData(path, "Sheet1", i, 2);
				String per2=XLUtils.getCellData(path, "Sheet1", i, 3);
				String fre=XLUtils.getCellData(path, "Sheet1", i, 4);
				
				String exp_mvalue=XLUtils.getCellData(path, "Sheet1", i, 5);
				
				//App code
				driver.findElement(By.id("principal")).sendKeys(pric);
				driver.findElement(By.id("interest")).sendKeys(rateofinterest);
				driver.findElement(By.id("tenure")).sendKeys(per1);
				
				Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
				perdrp.selectByVisibleText(per2);
				
				Select fredrp=new Select(driver.findElement(By.id("frequency")));
				fredrp.selectByVisibleText(fre);
				
				driver.findElement(By.xpath("//div[@class='PT25']//a[1]//img[1]")).click(); //Calculate
				
				Thread.sleep(3000);
				
				String act_mvalue=driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
				
				//validation
				if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
				{
					System.out.println("Test passed");
					XLUtils.setCellData(path,"Sheet1", i, 7, "Passed");
					XLUtils.fillGreenColor(path,"Sheet1", i, 7);
					
				}
				else
				{
					System.out.println("Test failed");
					XLUtils.setCellData(path,"Sheet1", i, 7, "Failed");
					XLUtils.fillRedColor(path,"Sheet1", i, 7);
				}
				
				driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
			}
			
			driver.close();

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
