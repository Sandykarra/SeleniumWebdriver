package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import day25.XLUtils;

public class DDT_usingdatabaseDATA {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		 System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
			driver.manage().window().maximize();
			
				//TO CREAT A CONNECTION
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","sandya84");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from caldata");
		
		while(rs.next()) {
			//get the row data from table
			int pric=rs.getInt("principle");
		int	r_intrest=rs.getInt("rateOfIntrest");
			int per1=rs.getInt("per1");
			String per2=rs.getString("per2");
			String freq=rs.getString("frequency");
			double exp_matvalue=rs.getInt("maturityvalue");
		

			//App code
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(pric));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(r_intrest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per1));
			
			Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.id("frequency")));
			fredrp.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//div[@class='PT25']//a[1]//img[1]")).click(); //Calculate
			
			Thread.sleep(3000);
			
			String act_mvalue=driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			
			//validation
			// already we declare the exp_mature value in double 
			if((exp_matvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test passed");
			stmt.execute("update caldata set STATUS='passed'");
				
			}
			else
			{
				System.out.println("Test failed");	
				stmt.execute("update caldata set STATUS='failed'");
			}
			
			driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click();
		}
		
		driver.close();





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
