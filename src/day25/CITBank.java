package day25;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CITBank {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
	driver.manage().window().minimize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Initialization.......
	
	String path="C:\\Demofiles\\test\\caldata2.xlsx";
	int rows=XLUtils.getRowCount(path, "Sheet1"); //row count
for(int r=1;r<=rows;r++)
{ 
	//System.out.println(r);//5
String IntialDeposit=XLUtils.getCellData(path, "Sheet1", r, 0); //initial deposit
String Intrest_rate=XLUtils.getCellData(path, "Sheet1", r, 1); //interest rate
String length=XLUtils.getCellData(path, "Sheet1", r, 2); //length
String compound=XLUtils.getCellData(path, "Sheet1", r, 3); //compounding
String total_cal=XLUtils.getCellData(path, "Sheet1", r, 4);// total

//application code
Thread.sleep(3000);

	WebElement IntialDp=driver.findElement(By.xpath("//input[@id = 'mat-input-0']"));
	IntialDp.clear();
	IntialDp.sendKeys(IntialDeposit);
	System.out.println(IntialDp);
	WebElement interest=driver.findElement(By.xpath("//input[@id=\"mat-input-2\"]"));
	interest.clear();
	interest.sendKeys(Intrest_rate);
	WebElement lengthOf=driver.findElement(By.xpath("//input[@id=\"mat-input-1\"]"));
	lengthOf.clear();
	lengthOf.sendKeys(length);
	//compounding
	Select comp=new Select(driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]/div/div[2]/div")));
	comp.selectByVisibleText(compound);
	WebElement total=driver.findElement(By.xpath("//button[@id=\"CIT-chart-submit\"]//div")); //click the Let's run the button

     total.click();

//actual total.............
String Actual_value=driver.findElement(By.xpath("//span[@id=\"displayTotalValue\"]")).getText(); //actual value
Thread.sleep(4000);

//validations
if(total_cal.equals(Actual_value)){
	System.out.println("Test case passed!");
	XLUtils.setCellData(path,"Sheet1", r, 6, "Passed");
	XLUtils.fillGreenColor(path,"Sheet1", r, 6);
}else {
	System.out.println("Test failed");
	XLUtils.setCellData(path,"Sheet1", r, 6, "failed");
	XLUtils.fillRedColor(path,"Sheet1", r, 6);
}

}
	
driver.close();	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
