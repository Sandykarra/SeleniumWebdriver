package practiceAllMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnoataionPractice1 {
WebDriver driver;
	@BeforeClass
	void Setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();	
	}
	//@Test(priority=1)
	void Logotest() throws InterruptedException{
		Thread.sleep(3000);
		boolean Logo=driver.findElement(By.xpath("//div[@id='divLogo']//img")).isSelected();
		
		Assert.assertTrue(true,"logo invisible");
	}
	@Test(dataProvider="orange")
void Login(String user, String pwd) {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	driver.findElement(By.id("txtUsername")).sendKeys(user);
	driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	driver.findElement(By.id("btnLogin")).click();
	
}

	@DataProvider(name="orange")
	String [][]LoginData(){
		String Data[][]={{ "Admin", "admin1"},{"Admin1",
			            "admin123"},{"admin","admin123"},{"Admin","Admin12"},
			                  {"Admin", "admin123"}};
		return Data;
		
			
		}
		
		
	
	@AfterClass
void tearDown() {
	driver.close();
}




}
