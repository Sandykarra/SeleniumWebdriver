package day25;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClassAnswer {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator/");
		driver.manage().window().maximize();
				
		WebElement inideposit = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));		
		WebElement length = driver.findElement(By.xpath("//input[@id='mat-input-0']"));	
		WebElement apr = driver.findElement(By.xpath("//input[@id='cdAPR']"));
		WebElement calbutton = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']"));
		
		System.out.println("user has identified all elements to calculate CD");
	
		String path="C:\\Demofiles\\caldata2.xlsx";   // giving path to file to start reading
		int rows=XLUtils.getRowCount(path, "Sheet1");				// get a row count from the sheet
		System.out.println("row count is : " + rows);
		
		for(int i=1;i<=rows;i++)
		{			
			//Reading data from excel
			String inidepo= XLUtils.getCellData(path,"Sheet1",i,0);				//file,sheet,row #, col zero for initial deposit
			String interestrate=XLUtils.getCellData(path,"Sheet1",i, 1);		//interest rate
			String monthlength=XLUtils.getCellData(path,"Sheet1",i, 2);			//length
			String compoundingmonths=XLUtils.getCellData(path,"Sheet1",i, 3);	//compounding
			String exptotal=XLUtils.getCellData(path,"Sheet1",i, 4);	//expected total , will be compared with actual total

			//passing the data into the application
			inideposit.clear();
			length.clear();
			apr.clear();
			Thread.sleep(3000);
			inideposit.sendKeys(inidepo);   //using webelement and passing the values from xl cell data
			length.sendKeys(monthlength);
			apr.sendKeys(interestrate);
						
			Select compoundrp = new Select(driver.findElement(By.xpath("//select[@id='cdCompounding']")));   //select class object compounddrp will find elelment by id
			compoundrp.selectByVisibleText(compoundingmonths);								//object will select by visible text from xldatacell 3rd column (index start with zero)
			calbutton.click();																//click on button to calculate cd calculation based on xl cell data
			String acttotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
			
			System.out.println("act total is: " + acttotal);
			System.out.println("exp total is: " + exptotal);
			
			if(exptotal.equals(acttotal)) {			//if expected total = actual totoal then			
				
				XLUtils.setCellData(path, "Sheet1",i, 6,"Passed");					//setting passed in 6th column (index start with zero)
				XLUtils.fillGreenColor(path, "Sheet1",i, 6);						//filling the color in 6th column if passed then greeen or faile then red.
			}
			else
			{
				XLUtils.setCellData(path, "Sheet1",i, 6,"Failed");
				XLUtils.fillRedColor(path, "Sheet1",i, 6);
			}
		}
			System.out.println("calculation has been completed");
			driver.close();
	
	
	
	
	
	
	
	
	
	
	
	}

}
