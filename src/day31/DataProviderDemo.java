package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	@BeforeClass
void setup() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	
}
@Test(dataProvider="dp1")
void test_login(String email, String pwd) {
	driver.get("https://demo.opencart.com/index.php?route=account/login");
	driver.findElement(By.id("input-email")).sendKeys(email);
driver.findElement(By.id("input-password")).sendKeys(pwd);
driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
//validations
String act_title="Account Login";
String exp_title=driver.getTitle();
Assert.assertEquals(act_title, exp_title,"Test failed..");

}
@AfterClass
void tearDown() {
	driver.close();
	
}
@DataProvider(name="dp1")
String [][]logindata(){
	String data[][]= {  {"bethisandhya.reddy@gmail.com","Welcome123"},
	                     {"bethisandhya.reddy5@gmail.com","Welcome123"},
	                       {"bethisandhya67.reddy@gmail.com","Welcome12345"},
	                         {"bethisandhya.reddy89@gmail.com","Welcome12"}};
	
	return data;                                            
	
	
}




}
